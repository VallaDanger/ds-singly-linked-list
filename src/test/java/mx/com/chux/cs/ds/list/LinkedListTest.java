package mx.com.chux.cs.ds.list;

import org.junit.*;

import static com.google.common.truth.Truth.assertWithMessage;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void initializeList() {
        this.list = new LinkedList<>(10);
    }

    @Test
    public void sizeAfterInsertTest() {
        this.list.add(1).add(2).add(3);
        assertWithMessage("size after insertion")
        .that(this.list.size()).isEqualTo(3);
    }

    @Test
    public void insertElementTest() {
        this.list.add(1);
        assertWithMessage("insert one element")
        .that(this.list.toString()).isEqualTo("{ 1 }");
    }

    @Test
    public void insertElementsTest() {
        this.list.add(1).add(2).add(3);
        assertWithMessage("insert elements")
        .that(list.toString()).isEqualTo("{ 1, 2, 3 }");
    }

    @Test
    public void popElementWhenEmptyTest() {
        assertWithMessage("pop when empty")
        .that(this.list.pop()).isNull();
    }

    @Test
    public void popElementWhenSizeIsOneTest() {
        this.list.add(1);
        assertWithMessage("pop when size == 1")
        .that(this.list.pop()).isEqualTo(1);
    }

    @Test
    public void popElementTest() {
        this.list.add(1).add(2).add(3);
        assertWithMessage("pop element")
        .that(this.list.pop()).isEqualTo(3);   
    }

    @Test
    public void reimainderAfterPopElementTest() {
        this.list.add(1).add(2).add(3).pop();
        assertWithMessage("remainder after pop element")
        .that(this.list.toString()).isEqualTo("{ 1, 2 }");  
    }

    @Test
    public void sizeAfterPopElementTest() {
        this.list.add(1).add(2).add(3).pop();
        assertWithMessage("size after pop element")
        .that(this.list.size()).isEqualTo(2);  
    }
    
    @Test
    public void sizeAterRemoveElementTest() {
        this.list.add(1).add(2).add(1).remove(1);
        assertWithMessage("remainder after remove element")
        .that(this.list.size()).isEqualTo(1);
    }
    
    @Test
    public void remainderAterRemoveElementV1Test() {
        this.list.add(1).add(2).add(1).remove(1);
        assertWithMessage("remainder after remove element v1")
        .that(this.list.toString()).isEqualTo("{ 2 }");
    }
    
    @Test
    public void remainderAterRemoveElementV2Test() {
        this.list.add(2).add(1).add(1).remove(1);
        assertWithMessage("remainder after remove element v2")
        .that(this.list.toString()).isEqualTo("{ 2 }");
    }
    
    @Test
    public void remainderAterRemoveElementV3Test() {
        this.list.add(2).add(1).add(1).remove(1);
        assertWithMessage("remainder after remove element v3")
        .that(this.list.toString()).isEqualTo("{ 2 }");
    }
    
    @Test
    public void remainderAterRemoveElementV4Test() {
        this.list.add(1).add(2).add(1).add(2).add(1).remove(1);
        assertWithMessage("remainder after remove element v4")
        .that(this.list.toString()).isEqualTo("{ 2, 2 }");
    }
    
    @Test
    public void remainderAterRemoveElementThatIsNotPresentTest() {
        this.list.add(2).remove(1);
        assertWithMessage("remainder after remove element that is not present")
        .that(this.list.toString()).isEqualTo("{ 2 }");
    }
    
    @Test
    public void invertSingletonListTest() {
        assertWithMessage("invert singleton list")
        .that(this.list.add(1).invert().toString())
        .isEqualTo("{ 1 }");
    }
    
    @Test
    public void invertListTest() {
        this.list.add(1).add(2).add(3).add(4).add(5);
        assertWithMessage("invert list")
        .that(this.list.invert().toString())
        .isEqualTo("{ 5, 4, 3, 2, 1 }");
    }
    
    @Test
    public void reverseSingletonListTest() {
        assertWithMessage("reverse singleton list")
        .that(this.list.add(1).reverse().toString())
        .isEqualTo("{ 1 }");
    }
    
    @Test
    public void reverseListTest() {
        this.list.add(1).add(2).add(3).add(4).add(5);
        assertWithMessage("reverse list")
        .that(this.list.reverse().toString())
        .isEqualTo("{ 5, 4, 3, 2, 1 }");
    }

}
