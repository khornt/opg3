import com.horntvedt.heis.domain.Heis;
import com.horntvedt.heis.state.Heistilstand;
import org.junit.Assert;
import org.junit.Test;



public class HeisserviceTest {


    @Test
    public void taHeisTil5() {
        Heis heisen = new Heis(5, "A");
        heisen.flyttHeis(5);

        Assert.assertEquals("Forventet retning ",  heisen.heistilstand(), Heistilstand.OPP);

    }

    @Test
    public void taHeisTil5ogNedTil2() {
        Heis heisen = new Heis(5, "A");

        heisen.flyttHeis(5);
        int i = heisen.flyttHeis(2);

        Assert.assertEquals("Forventet varighet ", i , 15);
        Assert.assertEquals("Forventet retning ",  heisen.heistilstand(), Heistilstand.NED);

    }
}



