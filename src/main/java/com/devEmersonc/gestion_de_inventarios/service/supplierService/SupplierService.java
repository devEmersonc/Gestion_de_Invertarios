package com.devEmersonc.gestion_de_inventarios.service.supplierService;

import com.devEmersonc.gestion_de_inventarios.dto.SaveSupplierDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SupplierDTO;
import com.devEmersonc.gestion_de_inventarios.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getSuppliers();
    SupplierDTO getSupplier(Long id);
    void saveSupplier(SaveSupplierDTO saveSupplierDTO);
    void updateSupplier(Long id, SaveSupplierDTO saveSupplierDTO);
    void deleteSupplier(Long id);
    SupplierDTO convertEntityToDto(Supplier supplier);
}
