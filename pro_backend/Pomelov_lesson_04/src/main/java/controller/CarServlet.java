package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.CarRepositoryMap;
import service.CarService;
import service.CarServiceImpl;

import java.io.IOException;
import java.util.Map;

public class CarServlet extends HttpServlet {

    private CarService service = new CarServiceImpl(new CarRepositoryMap());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> params= req.getParameterMap();

        if (params.isEmpty()) {

        } else {
            Long id = Long.parseLong(params.get("id")[0]);
            Car car = service.getById(id);
            resp.getWriter().write(car.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(req.getReader(), Car.class);
        service.save(car);
        resp.getWriter().write(car.toString());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
