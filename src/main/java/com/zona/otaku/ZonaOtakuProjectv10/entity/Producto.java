package com.zona.otaku.ZonaOtakuProjectv10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productos")
    private Long idProductos;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_unitario")
    private double costoUnitario;

    @Column(name = "precio_producto")
    private double precioProducto;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;


}
