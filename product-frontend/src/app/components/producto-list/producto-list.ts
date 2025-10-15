import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ProductoService, Producto } from '../../services/producto';

@Component({
  selector: 'app-producto-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './producto-list.html',
  styleUrls: ['./producto-list.css']
})
export class ProductoListComponent implements OnInit {

  productos: Producto[] = [];

  constructor(private productoService: ProductoService) {}

  ngOnInit(): void {
    this.cargarProductos();
  }

  cargarProductos(): void {
    this.productoService.getAll().subscribe({
      next: (data) => {
        console.log(' Productos cargados:', data);
        this.productos = data;
      },
      error: (err) => {
        console.error(' Error al cargar productos:', err);
      }
    });
  }

  deleteProducto(id: number): void {
    if (confirm('¿Seguro que deseas eliminar este producto?')) {
      this.productoService.delete(id).subscribe({
        next: () => {
          this.productos = this.productos.filter(p => p.idProducto !== id);
          alert('Producto eliminado');
        },
        error: (err) => console.error(' Error al eliminar producto:', err)
      });
    }
  }
}

