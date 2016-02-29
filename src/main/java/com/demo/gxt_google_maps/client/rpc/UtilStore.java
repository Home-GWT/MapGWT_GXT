package com.demo.gxt_google_maps.client.rpc;

import com.demo.gxt_google_maps.shared.Transit;

import java.util.ArrayList;
import java.util.List;

public class UtilStore {
    private static List<Transit> lData = null;

	public static List<Transit> loadData(){
		if(lData == null) {
            lData = new ArrayList<Transit>();
            lData.add(new Transit(1, "Loiane", "1234-5678", "loiane@email.com", "Loiane", "Hadson", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 45, 107, "Honda NSX", "NSX123", 423511, "53.587648', -2.558620'", 148, "bus", true));
            lData.add(new Transit(2, "Peter", "2345-6789", "peter@email.com", "Peter", "Hyustom", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 45, 101, "Hundai", "NSX123", 123456, "53.587648', -2.558620'", 48, "bus", true));
            lData.add(new Transit(3, "Andrew", "9876-1234", "andrew@email.com", "Andrew", "Maralin", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 100, 77, "Mazda", "NSX123", 654321, "53.587648', -2.558620'", 18, "car", false));
            lData.add(new Transit(4, "Caroline", "5647-8473", "caroline@email.com", "Caroline", "Lucene", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 45, 12, "Chevrole", "NSX123", 3245, "53.587648', -2.558620'", 180, "bus", true));
            lData.add(new Transit(5, "Jared", "4034-4585", "jared@email.com", "Jared", "Dandy", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 45, 87, "Volga 2000", "NSX123", 678, "53.587648', -2.558620'", 50, "bus", true));
            lData.add(new Transit(6, "Linda", "3455-0234", "linda@email.com", "Linda", "Mauvr", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 45, 63, "Moskvith 123", "NSX123", 999, "53.587648', -2.558620'", 60, "bus", true));
            lData.add(new Transit(7, "Elena", "3454-4543", "elena@email.com", "Elena", "Geporde", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 60, 137, "Mitcbisy", "NSX123", 100000, "53.587648', -2.558620'", 70, "truck", false));
            lData.add(new Transit(8, "Stefan", "5677-5677", "stefan@email.com", "Stefan", "Himary", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 45, 58, "Pagera", "NSX123", 20041, "53.587648', -2.558620'", 83, "bus", true));
            lData.add(new Transit(9, "Ana", "2434-2343", "ana@email.com", "Ana", "Mirabel", "2016-02-20 11:50:23", "2016-02-20 11:49:11", "2016-02-20 11:47:44", 65, 99, "Porshe", "NSX123", 42, "53.587648', -2.558620'", 10, "truck", false));
        }
		return lData;
	}
}
