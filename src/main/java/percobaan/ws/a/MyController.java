/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package percobaan.ws.a;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import percobaan.ws.a.exceptions.NonexistentEntityException;

/**
 *
 * @author AISYAH SUHERMAN
 */@Controller
public class MyController {
    Barangg data = new Barangg ();
    BaranggJpaController lati = new BaranggJpaController();
    
    @RequestMapping ("/barang/(id)")
    public String getBarangg(@PathVariable("id") int id) {
        try {
            data = lati.findBarangg (id);
            return data.getNama()+"<br>"+ data.getJumlah();
            
        }
        catch (Exception error){
            return "data tidak ada";
        }
        
    }
    
    @RequestMapping ("getall")
    public List <Barangg> getAllBarangg(){
        List<Barangg> Barangg = new ArrayList<Barangg>();
        return lati.findBaranggEntities();
    }
        
    @RequestMapping ("/delete/(id)")
    public String deleteBarangg(@PathVariable("id") int id){
        try{
            lati.destroy(id);
            return id + "Product is deleted successsfully";
        }
        catch (Exception error){return "Product deleted is error";
        
        }
    }
 }
    
    

