package data.structures.hashing;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class OpenAddressTests {

    OpenAddress oa = new OpenAddress(10);
    @Before
    public void setup(){
        oa.helperInsert(new Cell(5),5);
        oa.helperInsert(new Cell(6),6);
        oa.helperInsert(new Cell(9),9);
        oa.helperInsert(new Cell(3),3);
        oa.helperInsert(new Cell(null,true),4);

    }
    @Test
    public void canFindEmpty(){


       assertThat(oa.findNextEmpty(5)).isEqualTo(7);
        assertThat(oa.findNextEmpty(4)).isEqualTo(4);
        assertThat(oa.findNextEmpty(9)).isEqualTo(0);
        assertThat(oa.findNextEmpty(3)).isEqualTo(4);
    }

    @Test
    public void exists(){
        assertThat(oa.exists(5,5)).isTrue();
        assertThat(oa.exists(10,0)).isFalse();
        assertThat(oa.exists(6,5)).isTrue();
    }
}
