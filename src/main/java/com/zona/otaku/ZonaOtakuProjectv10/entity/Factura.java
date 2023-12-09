package com.zona.otaku.ZonaOtakuProjectv10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "descripcion_factura")
    private String descripcionFactura;

    @Column(name = "observacion_factura")
    private String observacionFactura;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factura")
    private List<ItemFactura> items;

    @PrePersist
    public void prePersist (){
        fechaRegistro = new Date();
    }

    public void addItemFactura (ItemFactura itemFactura){
        this.items.add(itemFactura);
    }

    public Double getTotal(){
        Double total = 0.0;

        int size = items.size();
        for (int i = 0; i < size; i++){
            total += items.get(i).calcularImporte();
        }
        return total;
    }

}
