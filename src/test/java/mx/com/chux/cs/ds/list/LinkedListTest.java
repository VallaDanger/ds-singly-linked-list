package mx.com.chux.cs.ds.list;

import org.junit.*;

import static com.google.common.truth.Truth.assertWithMessage;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void initializeList() {
        this.list = new LinkedList<>(3);
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
        assertWithMessage("pop when empty").that(this.list.pop()).isNull();
    }

    @Test
    public void popElementWhenSizeIsOneTest() {
        this.list.add(1);
        assertWithMessage("pop when size == 1").that(this.list.pop()).isEqualTo(1);
    }

    @Test
    public void popElementTest() {
        this.list.add(1).add(2).add(3);
        assertWithMessage("pop element").that(this.list.pop()).isEqualTo(3);   
    }

    @Test
    public void reimainderAfterPopTest() {
        this.list.add(1).add(2).add(3).pop();
        assertWithMessage("remainder after pop").that(this.list.toString()).isEqualTo("{ 1, 2 }");  
    }

    @Test
    public void sizeAfterPopTest() {
        this.list.add(1).add(2).add(3).pop();
        assertWithMessage("remainder after pop").that(this.list.size()).isEqualTo(2);  
    }

}
