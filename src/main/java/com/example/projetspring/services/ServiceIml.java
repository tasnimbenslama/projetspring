package com.example.projetspring.services;

import com.example.projetspring.entities.*;
import com.example.projetspring.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ServiceIml implements IService {
    private final eventRepository eventRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;
    private final PaternshipRepository paternshipRepository;
    private final ThematicRepository thematicRepository;
    @Override
    public event addevent(event e) {
        return eventRepository.save(e);
    }

    @Override
    public String delete(Integer id) {
        eventRepository.deleteById(id);
        return("event deleted ");
    }

    @Override
    public List<event> retreive() {
        return eventRepository.findAll();
    }

    @Override
    public user assignusertoevent( Integer id, Integer idEv) {
        user u =userRepository.findById(id).orElse(null);
        event e = eventRepository.findById(idEv).orElse(null);
        Set<event> events=new HashSet<>();
        events.add(e);
        u.setEvents(events);
        return userRepository.save(u);
    }

    @Override
    public project addp(project p) {
        return projectRepository.save(p);
    }

    @Override
    public String deletep(Integer id) {
        projectRepository.deleteById(id);
        return ("project deleted");
    }

    @Override
    public List<project> retreivep() {
        return projectRepository.findAll();
    }

    @Override
    public team addt(team t) {
        return teamRepository.save(t);
    }

    @Override
    public String deletet(Integer id) {
        teamRepository.deleteById(id);
        return (" team deleted");
    }

    @Override
    public List<team> retreivet() {
        return teamRepository.findAll();
    }

    @Override
    public void assignusertoteam(Integer id, Integer idT) {
        user u=userRepository.findById(id).orElse(null);
        team T=teamRepository.findById(idT).orElse(null);
        if (T.getUserSet()==null) {
            Set<user> userSet = new HashSet<>();
            userSet.add(u);
            T.setUserSet(userSet);
        }
        else {T.getUserSet().add(u);}
        teamRepository.save(T);

    }
    public void notassignusertoteam(Integer id, Integer idT) {
        user u = userRepository.findById(id).orElse(null);
        team T = teamRepository.findById(idT).orElse(null);

        T.setUserSet(null);

        teamRepository.save(T);
    }

    @Override
    public List<team> getAllBy(Integer idEv) {
        return teamRepository.getAllBy(idEv);
    }

    @Override
    public paternship addPattern(paternship p) {
        return paternshipRepository.save(p);
    }

    @Override
    public String deletepattern(Integer id) {
        return ("SOCIETY DELETED WITH SUCCES");
    }

    @Override
    public List<paternship> retreivepattern() {
        return paternshipRepository.findAll();
    }
    //affecter team to event
    public team  assignteamtoevent( Integer idT, Integer idEv) {
        team t =teamRepository.findById(idT).orElse(null);
        event e = eventRepository.findById(idEv).orElse(null);
        t.setEventt(e);
        return teamRepository.save(t);
    }
//affecter project to team
    @Override
    public team assignprojecttoteam( Integer id, Integer idT) {
        project p = projectRepository.findById(id).orElse(null);
        team t = teamRepository.findById(idT).orElse(null);
        t.setProjects(p);
        return teamRepository.save(t);
    }
}
