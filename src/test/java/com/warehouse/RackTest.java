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

import com.warehouse.domain.RackTypeEnum;
import com.warehouse.domain.WarehouseFamilyEnum;
import com.warehouse.model.Rack;
import com.warehouse.model.Warehouse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RackTest {

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
		final Warehouse beanWarehouse = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Rack bean1 = new Rack(beanWarehouse, ID, RackTypeEnum.A);
		final Rack bean2 = new Rack(beanWarehouse, ID, RackTypeEnum.A);
		
		bean2.setId(ID_2);
		bean2.setType(RackTypeEnum.B);
		
		
		assertEquals(ID, bean1.getId());
		assertEquals(ID_2, bean2.getId());
		assertEquals(RackTypeEnum.B, bean2.getType());
	}
	
	@Test
	void testGettersAndSetters() {
		final Warehouse beanWarehouse = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Rack bean = new Rack(beanWarehouse, ID, RackTypeEnum.A);
		
		// WHEN
		bean.setId(ID_2);
		bean.setType(RackTypeEnum.B);
		
		// THEN
		assertEquals(ID_2, bean.getId());
		assertEquals(RackTypeEnum.B, bean.getType());
	}
	
	@Test
	void testEqualsSameObject() {
		final Warehouse beanWarehouse = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Rack bean = new Rack(beanWarehouse, ID, RackTypeEnum.A);
			
		assertTrue(bean.equals(bean));
	}
	
	@Test
	void testNotEqualsToNull() {
		final Warehouse beanWarehouse = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Rack bean = new Rack(beanWarehouse, ID, RackTypeEnum.A);
		
		assertFalse(bean.equals(null));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testNotEqualsToObject() {
		final Warehouse beanWarehouse = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Rack bean = new Rack(beanWarehouse, ID, RackTypeEnum.A);
		final String stringObject = new String(UUID);
		
		assertFalse(bean.equals(stringObject));
	}
	
	@Test
	void testToString() {
		final Warehouse beanWarehouse = new Warehouse(ID, CLIENT, WarehouseFamilyEnum.EST, SIZE);
		final Rack bean = new Rack(beanWarehouse, ID, RackTypeEnum.A);
			
		assertNotEquals("", bean.toString());
	}
}
