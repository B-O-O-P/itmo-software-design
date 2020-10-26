package servlet;

import ru.akirakozov.sd.refactoring.dao.ProductDAO;
import ru.akirakozov.sd.refactoring.models.Product;
import ru.akirakozov.sd.refactoring.servlet.AddProductServlet;
import ru.akirakozov.sd.refactoring.servlet.ProductServlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddProductServletTest {

    @Mock
    private ProductDAO productDao;

    @Mock
    private HttpServletRequest servletRequest;

    @Mock
    private HttpServletResponse servletResponse;

    private ProductServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new AddProductServlet(productDao);
    }

    @Test
    public void testAddProductServlet() throws IOException, SQLException {
        when(servletRequest.getParameter("name"))
                .thenReturn("iphone6");
        when(servletRequest.getParameter("price"))
                .thenReturn("300");

        StringWriter stringWriter = new StringWriter();
        PrintWriter printer = new PrintWriter(stringWriter);
        when(servletResponse.getWriter())
                .thenReturn(printer);

        servlet.doGet(servletRequest, servletResponse);

        ArgumentCaptor<Product> product = ArgumentCaptor.forClass(Product.class);
        verify(productDao).insert(product.capture());

        printer.flush();
        assertThat(stringWriter.toString()).isEqualTo("OK" + System.lineSeparator());
        assertThat(product.getValue()).isEqualTo(new Product("iphone6", 300));
    }

}