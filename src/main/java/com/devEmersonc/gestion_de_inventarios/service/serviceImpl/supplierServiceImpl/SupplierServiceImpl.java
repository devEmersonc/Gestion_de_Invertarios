package com.devEmersonc.gestion_de_inventarios.service.serviceImpl.supplierServiceImpl;

import com.devEmersonc.gestion_de_inventarios.dto.SaveSupplierDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SupplierDTO;
import com.devEmersonc.gestion_de_inventarios.exception.SupplierNotFoundException;
import com.devEmersonc.gestion_de_inventarios.model.Supplier;
import com.devEmersonc.gestion_de_inventarios.repository.SupplierRepository;
import com.devEmersonc.gestion_de_inventarios.service.supplierService.SupplierService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierDTO> getSuppliers() {
        return supplierRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO getSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException());
        return this.convertEntityToDto(supplier);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void saveSupplier(SaveSupplierDTO saveSupplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(saveSupplierDTO.getName());
        supplier.setPhone(saveSupplierDTO.getPhone());
        supplier.setAddress(saveSupplierDTO.getAddress());
        supplier.setEmail(saveSupplierDTO.getEmail());
        supplierRepository.save(supplier);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateSupplier(Long id, SaveSupplierDTO saveSupplierDTO) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException());
        supplier.setName(saveSupplierDTO.getName());
        supplier.setPhone(saveSupplierDTO.getPhone());
        supplier.setAddress(saveSupplierDTO.getAddress());
        supplier.setEmail(saveSupplierDTO.getEmail());
        supplierRepository.save(supplier);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException());
        supplierRepository.deleteById(supplier.getId());
    }

    @Override
    public SupplierDTO convertEntityToDto(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName(supplier.getName());
        supplierDTO.setPhone(supplier.getPhone());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setEmail(supplier.getEmail());
        return supplierDTO;
    }
}
