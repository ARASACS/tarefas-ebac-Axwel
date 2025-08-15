import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teste {
    @Test
    public void teste(){
        List<Pessoas> pessoas = new ArrayList<>();
        pessoas.add(new Pessoas("Axwel","Masculino"));
        pessoas.add(new Pessoas("Maura","Feminino"));
        pessoas.add(new Pessoas("Pedro","Masculino"));
        pessoas.add(new Pessoas("Azrael","Masculino"));
        pessoas.add(new Pessoas("Acadine","Feminino"));
        pessoas.add(new Pessoas("Anselmo","Masculino"));
        pessoas.add(new Pessoas("Andiara","Feminino"));

        List<Pessoas> listaMulheres = pessoas.stream()
                .filter(pessoa -> pessoa.getGenero().startsWith("F"))
                .collect(Collectors.toList());

        boolean todasFemininas = listaMulheres.stream()
                .allMatch(p -> p.getGenero().equals("Feminino"));
        Assert.assertTrue(todasFemininas);

    }

}
