package com.example.projetspring.services;

import com.example.projetspring.entities.*;

import java.util.List;

public interface IService {
    event addevent (event e ) ;
    String delete (Integer id);
    List<event> retreive();
    User assignusertoevent(Integer id, Integer idEv);
    project addp (project p ) ;
    String deletep (Integer id);
    List<project> retreivep();
    team addt (team t ) ;
    String deletet (Integer id);
    List<team> retreivet();
    void assignusertoteam( Integer id, Integer idT);
    paternship addPattern (paternship p ) ;
    String deletepattern (Integer id);
    List<paternship> retreivepattern();
    public void notassignusertoteam(Integer id, Integer idT);
    List<team> getAllBy(Integer idEv);
    public team  assignteamtoevent( Integer idT, Integer idEv);
   team assignprojecttoteam(Integer id, Integer idT);
    //POUR LE SUIVIE
    followed addfollowed (followed f ) ;
    String deletefollowed (Integer id);
    List<followed> retreivefollowed();
     List<followed> getProductWithHighestPrice();
}
