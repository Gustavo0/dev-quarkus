package org.com;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.com.aplicacao.fruta.FrutasResource;
import org.com.aplicacao.fruta.FrutasService;
import org.com.dominio.fruta.Fruta;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {

    @Inject
    FrutasService frutasService;

    @Test
    public void testListFrutas() {
        given().when().get()
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"nome\":\"Maçã\",\"qtd\":5},{\"id\":2,\"nome\":\"Pera\",\"qtd\":3},{\"id\":3,\"nome\":\"Laranja\",\"qtd\":1}]"));
    }

    @Test
    public void testListFrutas2() {
        List<Fruta> list = frutasService.list();
        assertFalse(list.isEmpty());
    }

}