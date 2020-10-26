package servlet;

import ru.akirakozov.sd.refactoring.dao.ProductDAO;
import ru.akirakozov.sd.refactoring.models.Product;
import ru.akirakozov.sd.refactoring.servlet.ProductServlet;
import ru.akirakozov.sd.refactoring.servlet.QueryServlet;

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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class QueryServletTest {

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
        servlet = new QueryServlet(productDAO);
    }

    @Test
    public void testMax() throws IOException, SQLException {
        when(servletRequest.getParameter("command"))
                .thenReturn("max");

        when(productDAO.findMaxPrice())
                .thenReturn(Optional.of(new Product("iphone6", 200)));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printer = new PrintWriter(stringWriter);
        when(servletResponse.getWriter())
                .thenReturn(printer);

        servlet.doGet(servletRequest, servletResponse);

        printer.flush();
        assertThat(stringWriter.toString()).isEqualToIgnoringNewLines(
                "<html><body>" +
                        "<h1>Product with max price: </h1>" +
                        "iphone6\t200</br>" +
                "</body></html>"
        );
    }

    @Test
    public void testMin() throws IOException, SQLException {
        when(servletRequest.getParameter("command"))
                .thenReturn("min");

        when(productDAO.findMinPrice())
                .thenReturn(Optional.of(new Product("iphone6", 200)));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printer = new PrintWriter(stringWriter);
        when(servletResponse.getWriter())
                .thenReturn(printer);

        servlet.doGet(servletRequest, servletResponse);

        printer.flush();
        assertThat(stringWriter.toString()).isEqualToIgnoringNewLines(
                "<html><body>" +
                        "<h1>Product with min price: </h1>" +
                        "iphone6\t200</br>" +
                "</body></html>"
        );
    }

    @Test
    public void testSum() throws IOException, SQLException {
        when(servletRequest.getParameter("command"))
                .thenReturn("sum");

        when(productDAO.getSum())
                .thenReturn(1000L);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printer = new PrintWriter(stringWriter);
        when(servletResponse.getWriter())
                .thenReturn(printer);

        servlet.doGet(servletRequest, servletResponse);

        printer.flush();
        assertThat(stringWriter.toString()).isEqualToIgnoringNewLines(
                "<html><body>" +
                        "Summary price: " +
                        "1000" +
                "</body></html>"
        );
    }

    @Test
    public void testCount() throws IOException, SQLException {
        when(servletRequest.getParameter("command"))
                .thenReturn("count");

        when(productDAO.getCount())
                .thenReturn(2);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printer = new PrintWriter(stringWriter);
        when(servletResponse.getWriter())
                .thenReturn(printer);

        servlet.doGet(servletRequest, servletResponse);

        printer.flush();
        assertThat(stringWriter.toString()).isEqualToIgnoringNewLines(
                "<html><body>" +
                        "Number of products: " +
                        "2" +
                "</body></html>"
        );
    }

}