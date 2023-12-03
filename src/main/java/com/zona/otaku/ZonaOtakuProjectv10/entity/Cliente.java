package com.zona.otaku.ZonaOtakuProjectv10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotEmpty
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @NotEmpty
    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    @NotEmpty
    @Column(name = "direccion_cliente")
    private String direccionCliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "creacion_cliente")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creacionCliente;

//    @Column(name = "notas_cliente")
//    private String notasCliente;

    @NotEmpty
    @Column(name = "canal_contacto")
    private String canalContacto;

    @PrePersist
    public void prePersist(){
        creacionCliente = new Date();
    }
}
