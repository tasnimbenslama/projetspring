package com.example.projetspring.RestController;


import com.example.projetspring.entities.*;
import com.example.projetspring.services.IService;
import com.example.projetspring.services.imageservice;
import com.example.projetspring.services.service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RequestMapping("/app0")
@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class  RestController {
    private final IService iService;
    private final imageservice ims;
    @PostMapping("/create")
    public event create(@RequestBody event e){
        return  iService.addevent(e);
    }
    @GetMapping("/read")
    public List<event> read(){
        return iService.retreive();}
    @PutMapping("/update")
    public event update(@RequestBody event e){
        return iService.addevent(e);
    }
    @DeleteMapping ("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        return iService.delete(id);
    }
    @PutMapping("/affect/{id}/{idEv}")
    public user assignusertoevent(  @PathVariable("id") Integer id, @PathVariable("idEv") Integer idEv) {return iService.assignusertoevent(id,idEv);}

//project
    @PostMapping("/createp")
    public project create1(@RequestBody project p){
        return  iService.addp(p);
    }
    @GetMapping("/readp")
    public List<project> read1(){
        return iService.retreivep();}
    @PutMapping("/updatep")
    public project update1(@RequestBody project p){
        return iService.addp(p);
    }
    @DeleteMapping ("/deletep/{id}")
    public String delete1(@PathVariable("id") Integer id){
        return iService.deletep(id);
    }

    //team
    @PostMapping("/createt")
    public team create2(@RequestBody team  t){
        return  iService.addt(t);
    }
    @GetMapping("/readt")
    public List<team> read2(){
        return iService.retreivet();}
    @PutMapping("/updatet")
    public team update2(@RequestBody team t){
        return iService.addt(t);
    }
    @DeleteMapping ("/deletet/{id}")
    public String delete2(@PathVariable("id") Integer id){
        return iService.deletet(id);
    }
    @PutMapping("/assignUseroTeam/{id}/{idT}")
    public void assignusertoteam(@PathVariable("id") Integer id, @PathVariable("idT") Integer idT){iService.assignusertoteam(id,idT);
    }
    @PutMapping("/notassignUseroTeam/{id}/{idT}")
    public void assignusertoteam1(@PathVariable("id") Integer id, @PathVariable("idT") Integer idT){iService.notassignusertoteam(id,idT);}
//Pattern

    @PostMapping("/createpaternship")
    public paternship create3(@RequestBody paternship  p){
        return  iService.addPattern(p);
    }
    @GetMapping("/readpaternship")
    public List<paternship> read3(){
        return iService.retreivepattern();}
    @PutMapping("/updatepaternship")
    public paternship update3(@RequestBody paternship p){
        return iService.addPattern(p);
    }
    @DeleteMapping ("/deletepaternship/{id}")
    public String delete3(@PathVariable("id") Integer id){
        return iService.deletepattern(id);
    }
    @GetMapping("/retrieve teams from event/{idEv}")
    public List<team> read7(@PathVariable("idEv") Integer idEv){
        return iService.getAllBy(idEv);}
    @PutMapping("/assign team to event/{idT}/{idEv}")
    public team  assignteamtoevent( @PathVariable("idT") Integer idT,@PathVariable("idEv") Integer idEv){
        return iService.assignteamtoevent(idT,idEv);
    }
    @PutMapping("/assign project to team/{id}/{idT}")
    public team  assignteamtoevent1( @PathVariable("id") Integer id,@PathVariable("idT") Integer idT){
        return iService.assignprojecttoteam(id,idT);
    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Image attachment = null;
        attachment = ims.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        Image attachment = null;
        String downloadURl = "";
        attachment = ims.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return ("image uploaded succeffully");
    }




}

