package servlet;

import ru.akirakozov.sd.refactoring.dao.ProductDAO;
import ru.akirakozov.sd.refactoring.models.Product;
import ru.akirakozov.sd.refactoring.servlet.GetProductsServlet;
import ru.akirakozov.sd.refactoring.servlet.ProductServlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GetProductServletTest {

    @Mock
    private ProductDAO productDAO;

    @Mock
    private HttpServletRequest servletRequest;

    @Mock
    private HttpServletResponse servletResponse;

    private ProductServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new GetProductsServlet(productDAO);
    }

    @Test
    public void testGetProductServlet() throws IOException, SQLException {
        when(productDAO.getAll())
                .thenReturn(Arrays.asList(
                        new Product("iphone6", 200),
                        new Product("iphoneXr", 500),
                        new Product("iphone12", 700),
                        new Product("iphone12Pro", 1000)
                ));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printer = new PrintWriter(stringWriter);
        when(servletResponse.getWriter())
                .thenReturn(printer);

        servlet.doGet(servletRequest, servletResponse);

        printer.flush();

        assertThat(stringWriter.toString()).isEqualToIgnoringNewLines(
                "<html><body>" +
                        "iphone6\t200</br>" +
                        "iphoneXr\t500</br>" +
                        "iphone12\t700</br>" +
                        "iphone12Pro\t1000</br>" +
                "</body></html>"
        );
    }

}

