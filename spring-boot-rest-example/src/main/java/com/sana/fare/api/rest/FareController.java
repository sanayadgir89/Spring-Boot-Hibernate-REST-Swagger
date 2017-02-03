package com.sana.fare.api.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sana.fare.domain.Fare;
import com.sana.fare.exception.DataFormatException;
import com.sana.fare.service.FareService;


/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/v1/fares/route")
@Api(value = "fares", description = "Fare API")
public class FareController extends AbstractRestHandler {

	@Autowired
	private FareService fareService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {
			"application/json"/*, "application/xml" */}, produces = {
			"application/json"/*, "application/xml" */})
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a fare resource.", notes = "Returns the URL of the new resource in the Location header.")
	public void createFare(@RequestBody Fare fare, HttpServletRequest request,
			HttpServletResponse response) {
		Fare createdFare = this.fareService.createFare(fare);
		response.setHeader("Location", request.getRequestURL().append("/")
				.append(createdFare.getId()).toString());
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get a paginated list of all fares.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
	public @ResponseBody List<Fare> getAllFare(HttpServletRequest request,
			HttpServletResponse response) {
		return this.fareService.getAllFares();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get a single fare.", notes = "You have to provide a valid fare ID.")
	public @ResponseBody Fare getFare(
			@ApiParam(value = "The ID of the fare.", required = true) @PathVariable("id") Long id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Fare fare = this.fareService.getFare(id);
		checkResourceFound(fare);
		// todo: http://goo.gl/6iNAkz
		return fare;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {
			"application/json"/*, "application/xml"*/ }, produces = {
			"application/json"/*, "application/xml"*/ })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Update a fare resource.", notes = "You have to provide a valid fare ID in the URL and in the payload. The ID attribute can not be updated.")
	public void updateFare(
			@ApiParam(value = "The ID of the existing fare resource.", required = true) @PathVariable("id") Long id,
			@RequestBody Fare fare, HttpServletRequest request,
			HttpServletResponse response) {
		checkResourceFound(this.fareService.getFare(id));
		System.out.println("&&&&&&&" + fare);
		if (id != fare.getId())
			throw new DataFormatException("ID doesn't match!");
		this.fareService.updateFare(fare);
	}

	/*@ApiResponses({
		  @ApiResponse(code = 200, message = "Successful retrieval list of Fares", response = Product.class, responseContainer = "List"),
		  @ApiResponse(code = 404, message = "Client is not found", response = ErrorInfo.class),
		  @ApiResponse(code = 500, message = "Internal server error")
		})*/
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {
			"application/json"/*, "application/xml"*/ })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete a fare resource.", notes = "You have to provide a valid fare ID in the URL. Once deleted the resource can not be recovered.")
	public void deleteFare(
			@ApiParam(value = "The ID of the existing fare resource.", required = true) @PathVariable("id") Long id,
			HttpServletRequest request, HttpServletResponse response) {
		checkResourceFound(this.fareService.getFare(id));
		this.fareService.deleteFare(id);
	}
}
