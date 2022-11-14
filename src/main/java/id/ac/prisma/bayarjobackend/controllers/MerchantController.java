package id.ac.prisma.bayarjobackend.controllers;

import id.ac.prisma.bayarjobackend.data.model.TbMerchant;
import id.ac.prisma.bayarjobackend.data.model.TbUser;
import id.ac.prisma.bayarjobackend.data.repo.TbMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/merchant"})
public class MerchantController {

    @Autowired
    TbMerchantRepository tbMerchantRepository;

    @RequestMapping(value = "/get-all-merchant", method = RequestMethod.GET, produces = "application/json")
    public Iterable<TbMerchant> getAllMerchant(){
        Iterable<TbMerchant> allMerchant = tbMerchantRepository.findAll();
        return allMerchant;
    }

    @RequestMapping(value = "/by-id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Map getMerchantById(@PathVariable("id") Integer id) {
        Map response = new HashMap();
        TbMerchant tbMerchant = tbMerchantRepository.findById(id).orElse(null);
        response.put("data", tbMerchant);
        return response;
    }

    @RequestMapping(value = "/create-merchant", method = RequestMethod.POST, produces = "application/json")
    public Map createMerchant(@RequestBody Map bodyRequest) {
        // insert data
        // call tbMerchantRepository.save
        TbMerchant tbMerchant = new TbMerchant();
        tbMerchant.setName(bodyRequest.get("name").toString());
        tbMerchant.setEmail(bodyRequest.get("email").toString());
        tbMerchant.setAddress(bodyRequest.get("address").toString());
        tbMerchant = tbMerchantRepository.save(tbMerchant);

        Map response = new HashMap();
        response.put("data", tbMerchant);
        return response;
    }
}
