package com.zona.otaku.ZonaOtakuProjectv10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Producto> producto;
}
