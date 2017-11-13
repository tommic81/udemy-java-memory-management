package com.virtualpairprogrammers.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** 
 * This is a deliberate attempt to generate a "Memory Leak" - it's very unsubtle, in real
 * life leaks are much harder to spot.
 * @author cybrandian
 */
public class UUIDGenerator 
{
	//private static List<UUID> usedUUIDs = new ArrayList<UUID>();

	// VERY BAD METHOD IMPLEMENTATION!
	public static String newUUID() {
		
		return  UUID.randomUUID().toString();
		//while(true)
		/*{
			UUID candidate = UUID.randomUUID();
			if (!usedUUIDs.contains(candidate))
			{
				usedUUIDs.add(candidate);
				return candidate.toString();
			}
		}*/
	}
}
