package com.example.trabajodegrado.impservices;

import java.util.*;

import com.example.trabajodegrado.models.Insignia;

public interface IInsigniaService {
    
    public List<Insignia> getdInsignia();
    Optional<Insignia> editardInsignia(int iddInsignia);
    public void guardardInsignia(Insignia insignia);
    public void eliminardInsignia(int iddInsignia);

}
