package  com.projectGo.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.projectGo.model.vo.Menu;
import com.projectGo.model.vo.Store;

public class pre {
	
	public void savepre() {
		
		ArrayList<Store> list= new ArrayList<Store>();
		
		HashMap<String, Menu> m1 = new HashMap<String, Menu>();
		m1.put("메뉴1", new Menu("메뉴사진자리", 1500));
		m1.put("메뉴2", new Menu("메뉴사진자리", 2500));
		m1.put("메뉴3", new Menu("메뉴사진자리", 1800));
		m1.put("메뉴4", new Menu("메뉴사진자리", 2300));
		m1.put("메뉴5", new Menu("메뉴사진자리", 3000));
		m1.put("메뉴6", new Menu("메뉴사진자리", 1500));
		Store store1 = new Store("가게1", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.5, 1, 1500, m1);
		list.add(store1);
		HashMap<String, Menu> m2 = new HashMap<String, Menu>();
		m2.put("메뉴e1", new Menu("메뉴사진자리", 1500));
		m2.put("메뉴e2", new Menu("메뉴사진자리", 2500));
		m2.put("메뉴e3", new Menu("메뉴사진자리", 1800));
		m2.put("메뉴e4", new Menu("메뉴사진자리", 2300));
		m2.put("메뉴e5", new Menu("메뉴사진자리", 3000));
		m2.put("메뉴e6", new Menu("메뉴사진자리", 1500));
		Store store2 = new Store("가게2", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.0, 2, 1800, m2);
		list.add(store2);
		HashMap<String, Menu> m3 = new HashMap<String, Menu>();
		m3.put("메뉴a1", new Menu("메뉴사진자리", 1500));
		m3.put("메뉴a2", new Menu("메뉴사진자리", 2500));
		m3.put("메뉴a3", new Menu("메뉴사진자리", 1800));
		m3.put("메뉴a4", new Menu("메뉴사진자리", 2300));
		m3.put("메뉴a5", new Menu("메뉴사진자리", 3000));
		m3.put("메뉴a6", new Menu("메뉴사진자리", 1500));
		Store store3 = new Store("가게3", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 3.5, 3, 2500, m3);
		list.add(store3);
		HashMap<String, Menu> m4 = new HashMap<String, Menu>();
		m4.put("메뉴b1", new Menu("메뉴사진자리", 1500));
		m4.put("메뉴b2", new Menu("메뉴사진자리", 2500));
		m4.put("메뉴b3", new Menu("메뉴사진자리", 1800));
		m4.put("메뉴b4", new Menu("메뉴사진자리", 2300));
		m4.put("메뉴b5", new Menu("메뉴사진자리", 3000));
		m4.put("메뉴b6", new Menu("메뉴사진자리", 1500));
		Store store4 = new Store("가게4", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 2.5, 4, 2000, m4);
		list.add(store4);
		HashMap<String, Menu> m5 = new HashMap<String, Menu>();
		m5.put("메뉴d1", new Menu("메뉴사진자리", 1500));
		m5.put("메뉴d2", new Menu("메뉴사진자리", 2500));
		m5.put("메뉴d3", new Menu("메뉴사진자리", 1800));
		m5.put("메뉴d4", new Menu("메뉴사진자리", 2300));
		m5.put("메뉴d5", new Menu("메뉴사진자리", 3000));
		m5.put("메뉴d6", new Menu("메뉴사진자리", 1500));
		Store store5 = new Store("가게5", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.3, 5, 1500, m5);
		list.add(store5);
		HashMap<String, Menu> m6 = new HashMap<String, Menu>();
		m6.put("메뉴f1", new Menu("메뉴사진자리", 1500));
		m6.put("메뉴f2", new Menu("메뉴사진자리", 2500));
		m6.put("메뉴f3", new Menu("메뉴사진자리", 1800));
		m6.put("메뉴f4", new Menu("메뉴사진자리", 2300));
		m6.put("메뉴f5", new Menu("메뉴사진자리", 3000));
		m6.put("메뉴f6", new Menu("메뉴사진자리", 1500));
		Store store6 = new Store("가게6", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 1.5, 6, 1600, m6);
		list.add(store6);
		HashMap<String, Menu> m7 = new HashMap<String, Menu>();
		m7.put("메뉴g1", new Menu("메뉴사진자리", 1500));
		m7.put("메뉴g2", new Menu("메뉴사진자리", 2500));
		m7.put("메뉴g3", new Menu("메뉴사진자리", 1800));
		m7.put("메뉴g4", new Menu("메뉴사진자리", 2300));
		m7.put("메뉴g5", new Menu("메뉴사진자리", 3000));
		m7.put("메뉴g6", new Menu("메뉴사진자리", 1500));
		Store store7 = new Store("가게7", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.5, 7, 1500, m7);
		list.add(store7);
		HashMap<String, Menu> m8 = new HashMap<String, Menu>();
		m8.put("메뉴1h", new Menu("메뉴사진자리", 1500));
		m8.put("메뉴2h", new Menu("메뉴사진자리", 2500));
		m8.put("메뉴3h", new Menu("메뉴사진자리", 1800));
		m8.put("메뉴4h", new Menu("메뉴사진자리", 2300));
		m8.put("메뉴5h", new Menu("메뉴사진자리", 3000));
		m8.put("메뉴6h", new Menu("메뉴사진자리", 1500));
		Store store8 = new Store("가게8", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.9, 8, 1700, m8);
		list.add(store8);
		HashMap<String, Menu> m9 = new HashMap<String, Menu>();
		m9.put("메뉴1i", new Menu("메뉴사진자리", 1500));
		m9.put("메뉴2i", new Menu("메뉴사진자리", 2500));
		m9.put("메뉴3i", new Menu("메뉴사진자리", 1800));
		m9.put("메뉴4i", new Menu("메뉴사진자리", 2300));
		m9.put("메뉴5i", new Menu("메뉴사진자리", 3000));
		m9.put("메뉴6i", new Menu("메뉴사진자리", 1500));
		Store store9 = new Store("가게9", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.5, 9, 1800, m9);
		list.add(store9);
		HashMap<String, Menu> m10 = new HashMap<String, Menu>();
		m10.put("메뉴j1", new Menu("메뉴사진자리", 1500));
		m10.put("메뉴j2", new Menu("메뉴사진자리", 2500));
		m10.put("메뉴j3", new Menu("메뉴사진자리", 1800));
		m10.put("메뉴j4", new Menu("메뉴사진자리", 2300));
		m10.put("메뉴j5", new Menu("메뉴사진자리", 3000));
		m10.put("메뉴j6", new Menu("메뉴사진자리", 1500));
		Store store10 = new Store("가게10", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 3.8, 1, 1500, m10);
		list.add(store10);
		HashMap<String, Menu> m11 = new HashMap<String, Menu>();
		m11.put("메뉴k1", new Menu("메뉴사진자리", 1500));
		m11.put("메뉴k2", new Menu("메뉴사진자리", 2500));
		m11.put("메뉴k3", new Menu("메뉴사진자리", 1800));
		m11.put("메뉴k4", new Menu("메뉴사진자리", 2300));
		m11.put("메뉴k5", new Menu("메뉴사진자리", 3000));
		m11.put("메뉴k6", new Menu("메뉴사진자리", 1500));
		Store store11 = new Store("가게11", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.3, 2, 1600, m11);
		list.add(store11);
		HashMap<String, Menu> m12 = new HashMap<String, Menu>();
		m12.put("메뉴l1", new Menu("메뉴사진자리", 1500));
		m12.put("메뉴l2", new Menu("메뉴사진자리", 2500));
		m12.put("메뉴lk3", new Menu("메뉴사진자리", 1800));
		m12.put("메뉴lk4", new Menu("메뉴사진자리", 2300));
		m12.put("메뉴lk5", new Menu("메뉴사진자리", 3000));
		m12.put("메뉴lk6", new Menu("메뉴사진자리", 1500));
		Store store12 = new Store("가게12", "ㅁㄴㅇㅁ러설며여여엄나엄ㄴ아민러ㅣㅁㄴ러ㅣㅁㄴ러ㅣㅁㄴ러", 4.3, 3, 1700, m12);
		list.add(store12);
		

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store.txt"))) {

			for (int i = 0; i < list.size(); i++) {

				oos.writeObject(list.get(i));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

}
