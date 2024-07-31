package com.warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.warehouse.domain.WarehouseFamilyEnum;
import com.warehouse.model.Warehouse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WarehouseTest {

	private static final int ID = 1;
	
	private static final int ID_2 = 2;
	
	private static final String UUID = "UUID-1";
	
	private static final String CLIENT = "Amazon";
	
	private static final int SIZE = 2;
	
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testConstructors() {
		final Warehouse bean1 = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Warehouse bean2 = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		
		bean2.setId(ID_2);
		bean2.setFamily(WarehouseFamilyEnum.ROB);
		
		
		assertEquals(ID, bean1.getId());
		assertEquals(ID_2, bean2.getId());
		assertEquals(CLIENT, bean1.getClient());
		assertEquals(WarehouseFamilyEnum.ROB, bean2.getFamily());
		assertNull(bean1.getUuid());
	}
	
	@Test
	void testGettersAndSetters() {
		final Warehouse bean = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.ROB, SIZE);
		
		// WHEN
		bean.setId(ID_2);
		bean.setClient(CLIENT);
		bean.setFamily(WarehouseFamilyEnum.EST);
		bean.setSize(SIZE);
		
		// THEN
		assertEquals(ID_2, bean.getId());
		assertEquals(CLIENT, bean.getClient());
		assertEquals(WarehouseFamilyEnum.EST, bean.getFamily());
		assertEquals(SIZE, bean.getSize());
	}
	
	@Test
	void testEqualsSameObject() {
		final Warehouse bean = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.ROB, SIZE);
			
		assertTrue(bean.equals(bean));
	}
	
	@Test
	void testNotEqualsToNull() {
		final Warehouse bean = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.ROB, SIZE);
		
		assertFalse(bean.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testNotEqualsToObject() {
		final Warehouse bean = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.ROB, SIZE);
		final String stringObject = new String(UUID);
		
		assertFalse(bean.equals(stringObject));
	}
	
	@Test
	void testToString() {
		final Warehouse bean = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.ROB, SIZE);
			
		assertNotEquals("", bean.toString());
	}
}
