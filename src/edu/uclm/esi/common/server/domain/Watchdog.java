package edu.uclm.esi.common.server.domain;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Watchdog implements Runnable {

	private Manager manager;

	public Watchdog(Manager m){
		this.manager = m;
	}

	public void run() {
		while (true) {
			try {
				this.checkLastConnection();				
				
				this.checkPlayerWaiting();
				
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	private void checkLastConnection() {
		Iterator<User> it = this.manager.getAllUsers();
		double tenSecondsAgo = System.currentTimeMillis() - 10000;

		for (User user; it.hasNext();) {
			user = it.next();
			if (user.getLastConnection() < tenSecondsAgo) {
				try {
					this.manager.closeSession(user);
				} catch (SQLException e) {}
			}
		}
	}
}
