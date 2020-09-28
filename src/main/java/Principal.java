import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Produto produto = new Produto("Chocolate", 10.50);
        System.out.println("o valor do produto " + produto.getNome() + " é " + produto.getPreco());

        MongoClient cliente = new MongoClient();
        MongoDatabase bancoDeDados = cliente.getDatabase("test");
        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
        Document aluno = alunos.find().first();
        System.out.println(aluno);

        //Inserindo um novo aluno
        /*
        Document novoAluno = new Document("nome", "Florencio").append("data_nascimento", new Date(2003, 10, 10))
                .append("curso", new Document("nome", "Historia"))
                .append("notas", Arrays.asList(10, 9, 8))
                .append("habilidades", Arrays.asList(new Document()
                                .append("nome", "Inglês")
                                .append("nível", "Básico"),
                        new Document()
                                .append("nome", "Espanhol")
                                .append("nível", "Básico")));
        alunos.insertOne(novoAluno);


        //Vou fazer atualização agora
        alunos.updateOne(Filters.eq("nome","Florencio"),new Document("$set",
                new Document("nome", "Joao Silva")));
*/

        //Vou apagar o registro agora
        alunos.deleteOne(Filters.eq("nome","Joao Silva"));
        cliente.close();
    }
}
