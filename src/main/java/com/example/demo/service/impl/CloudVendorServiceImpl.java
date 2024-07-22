package com.example.demo.service.impl;

import com.example.demo.model.CloudVendor;
import com.example.demo.repository.CloudVendorRepository;
import com.example.demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "CloudVendor saved successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "CloudVendor updated successfully";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        Optional<CloudVendor> cv = cloudVendorRepository.findById(vendorId);
        String response = "CloudVendor deleted successfully";
        if(cv.isPresent()){
            cloudVendorRepository.deleteById(vendorId);
            response = "Given id not found";
        }
        return response;
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        CloudVendor cloudVendor=null;
        Optional<CloudVendor> cv = cloudVendorRepository.findById(vendorId);
        if(cv.isPresent())
            cloudVendor =  cv.get();
        else {
            System.out.println("Given id not found");
        }
        return cloudVendor;
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
