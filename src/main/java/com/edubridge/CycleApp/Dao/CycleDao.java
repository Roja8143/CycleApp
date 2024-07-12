package com.edubridge.CycleApp.Dao;

	import java.util.List;

import com.edubridge.CycleApp.model.Cycle;

	public interface CycleDao  {

		
		List<Cycle> getAllCycles();
		Cycle getCycle(String name);
		int addCycle(Cycle c);
		int updateCycle(Cycle c);
		int deleteCycle(String name);
		void deleteAllCycle();
	}

