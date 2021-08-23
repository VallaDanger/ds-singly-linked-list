package mx.com.chux.cs.ds.list;

import org.junit.*;

import static com.google.common.truth.Truth.assertWithMessage;

public class LinkedListTest {

    @Test
    public void listInsertionTest() {
        final LinkedList<Integer> list = new LinkedList<>(3);
        list.add(1).add(2).add(3);
        assertWithMessage("list insertion failed")
        .that(list.toString()).isEqualTo("{ 1, 2, 3 }" );
    }

}
