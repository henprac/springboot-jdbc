package pe.edu.tecsup.database;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.database.dao.CursoDAO;
import pe.edu.tecsup.database.model.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;

   // @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
             System.out.println(curso.getId());
            System.out.println(curso.getNombre());
             System.out.println(curso.getCodigo());
        }
        Assert.assertTrue(cursos.size() > 0);
    }
    

   // @Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(1l);
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 1l);
    }
    

    @Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setCodigo("1020");
        curso.setNombre("Nuevo Curso");
        curso.setDescripcion("......");

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

   //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(1l);
        curso.setCodigo("999");
        curso.setNombre("Curso Modificado");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(1l).getCodigo().equals("999"));
    }
 
   // @Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(44l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(44l) == null);
    }

}
