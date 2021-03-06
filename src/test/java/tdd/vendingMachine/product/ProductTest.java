package tdd.vendingMachine.product;

import java.util.Arrays;
import java.util.Collection;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import tdd.vendingMachine.IProduct;
import tdd.vendingMachine.IProductType;
import tdd.vendingMachine.PRODUCT_TYPE;
import tdd.vendingMachine.impl.product.Product;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.JVM)
public class ProductTest {

    private IProduct interfaceImpl;
    private IProductType productType = PRODUCT_TYPE.COLA;

    public ProductTest(IProduct interfaceImpl) {
        this.interfaceImpl = interfaceImpl;
    }

    @Test
    public final void testClassObjectNotNull() {
        assertNotNull(interfaceImpl);
    }

    @Test
    public final void testGetType() {
        assertTrue(productType.getType() == interfaceImpl.getType().getType());
    }

    @Test
    public final void testGetPrice() {
        assertTrue(productType.getPrice().compareTo(interfaceImpl.getPrice()) == 0);
    }

    @Test
    public final void testGetDesc() {
        assertTrue(productType.getDesc().compareTo(interfaceImpl.getDesc()) == 0);
    }

    @Test
    public final void testIsSame() {
        assertTrue(interfaceImpl.isSame(interfaceImpl));
    }

    @Parameterized.Parameters
    public static Collection<Object> instancesToTest() {
        return Arrays.asList(new Object[]{
                                            Product.createProducts(PRODUCT_TYPE.COLA, 1).firstElement()
                                            });
    }
}