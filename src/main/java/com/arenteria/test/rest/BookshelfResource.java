package com.arenteria.test.rest;

import com.arenteria.test.core.exception.InternalServerErrorException;
import com.arenteria.test.core.exception.NotFoundException;
import com.arenteria.test.core.exception.ServiceException;
import com.arenteria.test.domain.dto.BookDTO;
import com.arenteria.test.service.BookshelfService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/bookshelf")
@Produces(MediaType.APPLICATION_JSON)
public class BookshelfResource {

    private final BookshelfService bookshelfService;

    public BookshelfResource(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }

    @GET
    @Path("/books")
    public Response getAllBooks(
            @QueryParam("tittle") String title,
            @QueryParam("description") String description) {

        if (title != null){
            return Response.ok(bookshelfService.findBookByTittle(title)).build();
        }else{
            if(description != null){
                return Response.ok(bookshelfService.findBookByDescription(description)).build();

            }
        }

        return Response.ok(bookshelfService.findAllBooks()).build();
    }


    @GET
    @Path("/books/{id}")
    public Response getBook(@PathParam("id") Integer id) {
        try {
            BookDTO bookDTO = bookshelfService.findBookById(id);
            return Response.ok(bookDTO).build();
        } catch (ServiceException e) {
            NotFoundException notFoundException = new NotFoundException(404, "Book not found");
            return Response.noContent().entity(notFoundException).build();
        }
    }


    @POST
    @Path("/books")
    public Response saveBook(BookDTO bookDTO) {
        try {
            bookshelfService.saveBook(bookDTO);
            return Response.ok().entity("SUCCESS").build();
        } catch (ServiceException e) {
            InternalServerErrorException internalServerErrorException = new InternalServerErrorException(500, "The book could not be saved.");
            return Response.serverError().entity(internalServerErrorException).build();
        }

    }
}
