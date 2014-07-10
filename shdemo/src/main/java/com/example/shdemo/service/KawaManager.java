package com.example.shdemo.service;

import java.util.List;
import com.example.shdemo.domain.Kawa;

public interface KawaManager {
	
	int addNewKawa(Kawa kawa);
	List<Kawa> getAllKawa();
	Kawa findKawaById(int id);
	void deleteKawa(Kawa kawa);
	void updateKawa(Kawa kawa);
}