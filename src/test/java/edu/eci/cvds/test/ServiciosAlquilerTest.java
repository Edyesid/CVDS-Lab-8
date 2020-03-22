package edu.eci.cvds.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void consultarCostoAlquiler(){
        try{
            serviciosAlquiler.registrarItem(new Item(new TipoItem(1, "electrodomestico" ),99,
                             "item99", "item99", new SimpleDateFormat("yyyy/MM/dd").parse("2019/09/28"),
                                   99,"Digital","99"));
            serviciosAlquiler.consultarCostoAlquiler(89,2);
        }
        catch (ExcepcionServiciosAlquiler e ){
            Assert.assertEquals("El item no existe",e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}