package data.structures.hashing;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 7/11/14.
 */
public class OpenAddressingTests {

    OpenAddress oa = new OpenAddress(10);
    @Before
    public void setup(){
        oa.insert(5);
        oa.insert(15);
        oa.insert(25);
        oa.insert(3);
        oa.insert(13);
        oa.insert(9);
        oa.insert(7);
    }

    @Test
    public void canFind(){
        assertThat(oa.find(5).intValue()).isEqualTo(5);
        assertThat(oa.find(15).intValue()).isEqualTo(6);
        assertThat(oa.find(25).intValue()).isEqualTo(7);
        assertThat(oa.find(55)).isNull();
        assertThat(oa.find(3).intValue()).isEqualTo(3);
    }

    @Test
     public void canInsertMore(){
        oa.insert(23);
        assertThat(oa.find(23)).isNotNull();
    }

    @Test(expected = RuntimeException.class)
    public void cannotInsertMoreThanSize(){
        oa.insert(23);
        oa.insert(24);
        oa.insert(255);
        assertThat(oa.find(23)).isNotNull();
        assertThat(oa.find(24)).isNotNull();
        assertThat(oa.find(255)).isNotNull();

        oa.insert(55);
    }

    @Test
    public void cannotFindAfterDelete(){
        assertThat(oa.find(25)).isNotNull();
        oa.delete(25);
        assertThat(oa.find(25)).isNull();
    }

    @Test
    public void deletingFreesUpSpace(){
        oa.insert(23);
        oa.insert(24);
        oa.insert(255);
        assertThat(oa.find(23)).isNotNull();
        assertThat(oa.find(24)).isNotNull();
        assertThat(oa.find(255)).isNotNull();

        try{
            oa.insert(55);
        }
        catch(RuntimeException re){
            //expected
            oa.delete(23);
            oa.insert(55);
            assertThat(oa.find(55)).isNotNull();
        }

    }

}
