package com.devEmersonc.gestion_de_inventarios.controller;

import com.devEmersonc.gestion_de_inventarios.dto.SaveSupplierDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SupplierDTO;
import com.devEmersonc.gestion_de_inventarios.service.supplierService.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable Long id) {
        SupplierDTO supplier = supplierService.getSupplier(id);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<String> saveSupplier(@Valid @RequestBody SaveSupplierDTO saveSupplierDTO) {
        supplierService.saveSupplier(saveSupplierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha guardado el nuevo proveedor.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSupplier(@Valid @RequestBody SaveSupplierDTO saveSupplierDTO, @PathVariable Long id) {
        supplierService.updateSupplier(id, saveSupplierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha actualizado la información del proveedor.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Proveedor eliminado.");
    }
}
