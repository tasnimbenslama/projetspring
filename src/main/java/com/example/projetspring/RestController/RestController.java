package com.example.projetspring.RestController;


import com.example.projetspring.entities.*;
import com.example.projetspring.repository.FollowedRepository;
import com.example.projetspring.repository.PaternshipRepository;
import com.example.projetspring.repository.eventRepository;
import com.example.projetspring.services.IService;
import com.example.projetspring.services.StorageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Table;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/app0")
@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
@Validated
public class  RestController {
    private final IService iService;
    private StorageService service;
    eventRepository ev;

    PaternshipRepository paternshipRepository;

    @PostMapping("/createEvent")
    public event create(@Valid @RequestBody   event e) {
        return iService.addevent(e);

    }

    @GetMapping("/readEvent")
    public List<event> read() {
        return iService.retreive();
    }

    @PutMapping("/updateEvent")
    public event update(@RequestBody event e) {
        return iService.addevent(e);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return iService.delete(id);
    }

    @PutMapping("/affectUserToEvent/{id}/{idEv}")
    public User assignusertoevent(@PathVariable("id") Integer id, @PathVariable("idEv") Integer idEv) {
        return iService.assignusertoevent(id, idEv);
    }

    //project
    @PostMapping("/createproject")
    public project create1(@RequestBody project p) {
        return iService.addp(p);
    }

    @GetMapping("/readproject")
    public List<project> read1() {
        return iService.retreivep();
    }

    @PutMapping("/updateproject")
    public project update1(@RequestBody project p) {
        return iService.addp(p);
    }

    @DeleteMapping("/deleteproject/{id}")
    public String delete1(@PathVariable("id") Integer id) {
        return iService.deletep(id);
    }

    //team
    @PostMapping("/createteam")
    public team create2(@RequestBody team t) {
        return iService.addt(t);
    }

    @GetMapping("/readteam")
    public List<team> read2() {
        return iService.retreivet();
    }

    @PutMapping("/updateteam")
    public team update2(@RequestBody team t) {
        return iService.addt(t);
    }

    @DeleteMapping("/deleteteam/{id}")
    public String delete2(@PathVariable("id") Integer id) {
        return iService.deletet(id);
    }

    @PutMapping("/assignUseroTeam/{id}/{idT}")
    public void assignusertoteam(@PathVariable("id") Integer id, @PathVariable("idT") Integer idT) {
        iService.assignusertoteam(id, idT);
    }

    @PutMapping("/notassignUseroTeam/{id}/{idT}")
    public void assignusertoteam1(@PathVariable("id") Integer id, @PathVariable("idT") Integer idT) {
        iService.notassignusertoteam(id, idT);
    }
//Pattern

    @PostMapping("/createpaternship")
    public paternship create3(@RequestBody paternship p) {
        return iService.addPattern(p);
    }

    @GetMapping("/readpaternship")
    public List<paternship> read3() {
        return iService.retreivepattern();
    }

    @PutMapping("/updatepaternship")
    public paternship update3(@RequestBody paternship p) {
        return iService.addPattern(p);
    }

    @DeleteMapping("/deletepaternship/{id}")
    public String delete3(@PathVariable("id") Integer id) {
        return iService.deletepattern(id);
    }

    @GetMapping("/retrieve teams from event/{idEv}")
    public List<team> read7(@PathVariable("idEv") Integer idEv) {
        return iService.getAllBy(idEv);
    }

    @PutMapping("/assign team to event/{idT}/{idEv}")
    public team assignteamtoevent(@PathVariable("idT") Integer idT, @PathVariable("idEv") Integer idEv) {
        return iService.assignteamtoevent(idT, idEv);
    }

    @PutMapping("/assign project to team/{id}/{idT}")
    public team assignteamtoevent1(@PathVariable("id") Integer id, @PathVariable("idT") Integer idT) {
        return iService.assignprojecttoteam(id, idT);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {

        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File("C:\\uploads\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }

    @PostMapping("/ol")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        byte[] imageData = service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }



    //FOLLOWED
    @PostMapping("/createfollowed")
    public followed create4(@RequestBody followed f) {
        return iService.addfollowed(f);
    }

    @GetMapping("/readfollowed")
    public List<followed> read4() {
        return iService.retreivefollowed();
    }

    @PutMapping("/updatefollowed")
    public followed update4(@RequestBody followed f) {
        return iService.addfollowed(f);
    }

    @DeleteMapping("/deletefollowed/{id}")
    public String delete4(@PathVariable("id") Integer id) {
        return iService.deletefollowed(id);
    }

    @GetMapping("/ListOfPatnerships")
    public List<paternship> searchPatnership(@RequestParam(name = "q") String query) {
        return paternshipRepository.findByNameContainingIgnoreCase(query);
    }

    @GetMapping("/highestproduct")
    public List<followed> getProductWithHighestPrice() {
         return iService.getProductWithHighestPrice();}
    //pdf
    @GetMapping("/pdf")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=test.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        List<team> teams = iService.retreivet();
        List<event>events=iService.retreive();
        document.open();
        document.add(new Paragraph("THIS IS A LIST OF TEAMS FROM THIS YEAR!"));
        for (team t : teams ) {
            for (event e : events) {
                Paragraph paragraph = new Paragraph("team:   " +"["+ t.getName() +"]"+"    "+ "inscrits a l'evenement qui commence"   +"["+ e.getStartDate()+"]");
                document.add(paragraph);
            }
        }
        document.close();
        }
    }








