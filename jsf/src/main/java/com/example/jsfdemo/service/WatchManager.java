package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Watch;

@ApplicationScoped
public class WatchManager {
	List<Watch> db = new ArrayList<Watch>();

	public List<Watch> writeAllWatchs() {
		return db;
	}

	public void addWatch(Watch watch) {
		Watch tmp = new Watch();

		tmp.setModel(watch.getModel());
		tmp.setPrice(watch.getPrice());
		tmp.setProducer(watch.getProducer());
		tmp.setStrapLength(watch.getStrapLength());
		tmp.setSerialNumber(watch.getSerialNumber());
		tmp.setDop(watch.getDop());
		db.add(tmp);
	}

	public void delWatch(Watch watch) {
		int i = 0;
		for (Watch e : db) {
			if (e.getSerialNumber().equals(watch.getSerialNumber())) {
				db.remove(i);
				break;
			}
			i++;
		}
	}

	public ArrayList<Watch> searchWatch(Watch watch) {
		ArrayList<Watch> tmp = new ArrayList<Watch>();
		for (Watch e : db) {
			if (e.getProducer().equals(watch.getProducer())) {
				tmp.add(e);
			}
		}

		return tmp;
	}
}