/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realdeal.homepageservice.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.realdeal.homepageservice.crimeometer.CrimeDetails;
import com.realdeal.homepageservice.crimeometer.CrimeIncedents;
import com.realdeal.homepageservice.dtos.HomeViewModel;
import com.realdeal.homepageservice.entity.MaDealCalculation;
import com.realdeal.homepageservice.entity.MaRestapiKeys;
import com.realdeal.homepageservice.entity.MaUserPreferences;
import com.realdeal.homepageservice.services.ApiKeyService;
import com.realdeal.homepageservice.services.DealCalculationService;
import com.realdeal.homepageservice.services.UserPreferencesService;
import com.realdeal.homepageservice.simplyrets.Location;
import com.realdeal.homepageservice.simplyrets.RestProperty;
import com.realdeal.homepageservice.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//import org.eclipse.jdt.internal.compiler.env.ISourceType;

@RestController("home")
public class HomeController {

    @Autowired
    InternalRenderer internalRenderer;

    @Autowired
    SessionUtils sessionUtils;

    @Autowired
    DealCalculationService dealCalculationService;

    @Autowired
    ApiKeyService apiKeyService;

    @Autowired
    UserPreferencesService preferencesService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String Index(HttpServletRequest request, Model model) throws IOException {
//
//        if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) != null) {
//            return "redirect:/Home";
//        }
//        return "Home/Index";
//
//    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String Index(HttpServletRequest request, @ModelAttribute("user") @Valid IndexViewModel user, BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            List<ObjectError> errors = result.getAllErrors();
//            model.addAttribute("errors", errors);
//        } else {
//            if (user.getPassword().equals(StatusEnums.PASSWORD.toString())) {
//                sessionUtils.setSessionValue(request, StatusEnums.ISALLOWED_KEY.toString(), StatusEnums.ISALLOWED.toString());
//                return "redirect:/Home";
//            } else {
//                List<ObjectError> errors = new ArrayList<ObjectError>();
//                errors.add(new ObjectError("password", "Invalid password"));
//                model.addAttribute("errors", errors);
//            }
//
//        }
//        return "Home/Index";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity home(HttpServletRequest request, Model model) throws IOException, UnAthorizedSiteAccessException {

//        if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) == null) {
//            throw new UnAthorizedSiteAccessException("");
//        }

        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setbFilter(true);
        homeViewModel.setPropertyStatus("Sale");
        //homeViewModel.setPropertySubType("singlefamilyresidence");
        homeViewModel = SearchProperty(50, homeViewModel, request);
        //  model.addAttribute("homemodel", homeViewModel);
        return ResponseEntity.ok(homeViewModel);

    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<HomeViewModel> save(HttpServletRequest request, Model model) throws IOException, UnAthorizedSiteAccessException {
        System.out.println("inpost");
//        if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) == null) {
//            throw new UnAthorizedSiteAccessException("");
//        }
        HomeViewModel homeViewModel = new HomeViewModel();
        try {

            homeViewModel.setbFilter(Boolean.TRUE);
            if (request.getParameter("Search") != null && !"".equals(request.getParameter("Search"))) {
                homeViewModel.setSearch(request.getParameter("Search"));
            }
            if (request.getParameter("MinPrice") != null && !"".equals(request.getParameter("MinPrice")) && !"null".equalsIgnoreCase(request.getParameter("MinPrice"))) {
                homeViewModel.setMinPrice(new BigDecimal(request.getParameter("MinPrice")));
            }
            if (request.getParameter("MaxPrice") != null && !"".equals(request.getParameter("MaxPrice")) && !"null".equalsIgnoreCase(request.getParameter("MaxPrice"))) {
                homeViewModel.setMaxPrice(new BigDecimal(request.getParameter("MaxPrice")));
            }
            if (request.getParameter("MinLotSize") != null && !"".equals(request.getParameter("MinLotSize")) && !"null".equalsIgnoreCase(request.getParameter("MinLotSize"))) {
                homeViewModel.setMinLotSize(Long.valueOf(request.getParameter("MinLotSize")));
            }
            if (request.getParameter("MaxLotSize") != null && !"".equals(request.getParameter("MaxLotSize")) && !"null".equalsIgnoreCase(request.getParameter("MaxLotSize"))) {
                homeViewModel.setMaxLotSize(Long.valueOf(request.getParameter("MaxLotSize")));
            }
            if (request.getParameter("MaxHoaFees") != null && !"".equals(request.getParameter("MaxHoaFees")) && !"null".equalsIgnoreCase(request.getParameter("MaxHoaFees"))) {
                homeViewModel.setMaxHoaFees(new BigDecimal(request.getParameter("MaxHoaFees")));
            }
            if (request.getParameter("PropertyStatus") != null && !"".equals(request.getParameter("PropertyStatus"))) {
                homeViewModel.setPropertyStatus(request.getParameter("PropertyStatus"));
            }
            if (request.getParameter("PropertySubType") != null && !"".equals(request.getParameter("PropertySubType"))) {
                homeViewModel.setPropertySubType(request.getParameter("PropertySubType"));
            }
            if (request.getParameter("MinBeds") != null && !"".equals(request.getParameter("MinBeds")) && !"null".equalsIgnoreCase(request.getParameter("MinBeds"))) {
                homeViewModel.setMinBeds(Long.valueOf(request.getParameter("MinBeds")));
            }
            if (request.getParameter("MaxBeds") != null && !"".equals(request.getParameter("MaxBeds")) && !"null".equalsIgnoreCase(request.getParameter("MaxBeds"))) {
                homeViewModel.setMaxBeds(Long.valueOf(request.getParameter("MaxBeds")));
            }
            if (request.getParameter("MinBaths") != null && !"".equals(request.getParameter("MinBaths")) && !"null".equalsIgnoreCase(request.getParameter("MinBaths"))) {
                homeViewModel.setMinBaths(Long.valueOf(request.getParameter("MinBaths")));
            }
            if (request.getParameter("MaxBaths") != null && !"".equals(request.getParameter("MaxBaths")) && !"null".equalsIgnoreCase(request.getParameter("MaxBaths"))) {
                homeViewModel.setMaxBaths(Long.valueOf(request.getParameter("MaxBaths")));
            }
            if (request.getParameter("MinYear") != null && !"".equals(request.getParameter("MinYear")) && !"null".equalsIgnoreCase(request.getParameter("MinYear"))) {
                homeViewModel.setMinYear(Long.valueOf(request.getParameter("MinYear")));
            }
            if (request.getParameter("MaxYear") != null && !"".equals(request.getParameter("MaxYear")) && !"null".equalsIgnoreCase(request.getParameter("MaxYear"))) {
                homeViewModel.setMaxYear(Long.valueOf(request.getParameter("MaxYear")));
            }
            if (request.getParameter("MinSqft") != null && !"".equals(request.getParameter("MinSqft")) && !"null".equalsIgnoreCase(request.getParameter("MinSqft"))) {
                homeViewModel.setMinSqft(Long.valueOf(request.getParameter("MinSqft")));
            }
            if (request.getParameter("MaxSqft") != null && !"".equals(request.getParameter("MaxSqft")) && !"null".equalsIgnoreCase(request.getParameter("MaxSqft"))) {
                homeViewModel.setMaxSqft(Long.valueOf(request.getParameter("MaxSqft")));
            }
            if (request.getParameter("ZipCode") != null && !"".equals(request.getParameter("ZipCode"))) {
                homeViewModel.setZipCode(request.getParameter("ZipCode"));
            }
            homeViewModel = SearchProperty(500, homeViewModel, request);

        } catch (Exception ex) {
            homeViewModel.setError(ex.getMessage());
        }
        //  model.addAttribute("homemodel", homeViewModel);
        return ResponseEntity.ok(homeViewModel);

    }

    // This method is used to get the properties list by lat and lng list
    //This method is used when you draw any shape on google map through ajax
    @RequestMapping(value = "/GetPropertiesByPoints", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity GetPropertiesByPoints(Model model, HttpServletResponse mainresponse, HttpServletRequest request, Locale locale) throws Exception {
        HomeViewModel homeViewModel = new HomeViewModel();

        try {

            if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) == null) {
                throw new UnAthorizedSiteAccessException("");
            }

            HttpClient client = HttpClientBuilder.create().build();

            String query = StatusEnums.SIMPLYRETS_BASEAPI.toString() + "/properties?include=association&include=agreement&include=garageSpaces&include=maintenanceExpense&include=parking&include=pool&include=rooms&include=taxAnnualAmount&include=taxYear&" + request.getParameter("points");

            if (request.getParameter("Search") != null
                    && !StringUtils.isBlank(request.getParameter("Search"))
                    && !StringUtils.isWhitespace(request.getParameter("Search")) && !StringUtils.isEmpty(request.getParameter("Search"))) {
                query += "&q=" + request.getParameter("Search").replaceAll("\\s", "");
            }

            if (request.getParameter("MinPrice") != null && !StringUtils.isBlank(request.getParameter("MinPrice")) && !StringUtils.isWhitespace(request.getParameter("MinPrice")) && !StringUtils.isEmpty(request.getParameter("MinPrice"))) {
                query += "&minprice=" + request.getParameter("MinPrice");
            }

            if (request.getParameter("MaxPrice") != null && !StringUtils.isBlank(request.getParameter("MaxPrice")) && !StringUtils.isWhitespace(request.getParameter("MaxPrice")) && !StringUtils.isEmpty(request.getParameter("MaxPrice"))) {
                query += "&maxprice=" + request.getParameter("MaxPrice");
            }

            if (request.getParameter("MinLotSize") != null && !StringUtils.isBlank(request.getParameter("MinLotSize")) && !StringUtils.isWhitespace(request.getParameter("MinLotSize")) && !StringUtils.isEmpty(request.getParameter("MinLotSize"))) {
                query += "&minacres=" + request.getParameter("MinLotSize");
            }

            if (request.getParameter("MaxLotSize") != null && !StringUtils.isBlank(request.getParameter("MaxLotSize")) && !StringUtils.isWhitespace(request.getParameter("MaxLotSize")) && !StringUtils.isEmpty(request.getParameter("MaxLotSize"))) {
                query += "&maxacres=" + request.getParameter("MaxLotSize");
            }

            if (request.getParameter("PropertyStatus") != null && !StringUtils.isBlank(request.getParameter("PropertyStatus")) && !StringUtils.isWhitespace(request.getParameter("PropertyStatus")) && !StringUtils.isEmpty(request.getParameter("PropertyStatus"))) {
                if (request.getParameter("PropertyStatus").equals("rental")) {
                    query += "&type=" + request.getParameter("PropertyStatus");
                } else if (request.getParameter("PropertyStatus").equals("Sale")) {
                    query += "&type=residential,condominium,multifamily,commercial,land,farm";
                } else if (request.getParameter("PropertyStatus").equals("All")) {
                    query += "&status=Active";
                } else {
                    query += "&status=" + request.getParameter("PropertyStatus");
                }

            } else {
                query += "&status=Active";
            }

            if (request.getParameter("PropertySubType") != null && !StringUtils.isBlank(request.getParameter("PropertySubType")) && !StringUtils.isWhitespace(request.getParameter("PropertySubType")) && !StringUtils.isEmpty(request.getParameter("PropertySubType"))) {

                if (!request.getParameter("PropertySubType").equalsIgnoreCase("other")) {
                    query += "&subtype=" + request.getParameter("PropertySubType").toLowerCase();
                }
            }

            if (request.getParameter("MinBeds") != null && !StringUtils.isBlank(request.getParameter("MinBeds")) && !StringUtils.isWhitespace(request.getParameter("MinBeds")) && !StringUtils.isEmpty(request.getParameter("MinBeds"))) {
                query += "&minbeds=" + request.getParameter("MinBeds");
            }

            if (request.getParameter("MaxBeds") != null && !StringUtils.isBlank(request.getParameter("MaxBeds")) && !StringUtils.isWhitespace(request.getParameter("MaxBeds")) && !StringUtils.isEmpty(request.getParameter("MaxBeds"))) {
                query += "&maxbeds=" + request.getParameter("MaxBeds");
            }

            if (request.getParameter("MinBaths") != null && !StringUtils.isBlank(request.getParameter("MinBaths")) && !StringUtils.isWhitespace(request.getParameter("MinBaths")) && !StringUtils.isEmpty(request.getParameter("MinBaths"))) {
                query += "&minbaths=" + request.getParameter("MinBaths");
            }

            if (request.getParameter("MaxBaths") != null && !StringUtils.isBlank(request.getParameter("MaxBaths")) && !StringUtils.isWhitespace(request.getParameter("MaxBaths")) && !StringUtils.isEmpty(request.getParameter("MaxBaths"))) {
                query += "&maxbaths=" + request.getParameter("MaxBaths");
            }

            if (request.getParameter("MinYear") != null && !StringUtils.isBlank(request.getParameter("MinYear")) && !StringUtils.isWhitespace(request.getParameter("MinYear")) && !StringUtils.isEmpty(request.getParameter("MinYear"))) {
                query += "&minyear=" + request.getParameter("MinYear");
            }
            if (request.getParameter("MaxYear") != null && !StringUtils.isBlank(request.getParameter("MaxYear")) && !StringUtils.isWhitespace(request.getParameter("MaxYear")) && !StringUtils.isEmpty(request.getParameter("MaxYear"))) {
                query += "&maxyear=" + request.getParameter("MaxYear");
            }
            if (request.getParameter("MinSqft") != null && !StringUtils.isBlank(request.getParameter("MinSqft")) && !StringUtils.isWhitespace(request.getParameter("MinSqft")) && !StringUtils.isEmpty(request.getParameter("MinSqft"))) {
                query += "&minsqft=" + request.getParameter("MinSqft");
            }
            if (request.getParameter("MaxSqft") != null && !StringUtils.isBlank(request.getParameter("MaxSqft")) && !StringUtils.isWhitespace(request.getParameter("MaxSqft")) && !StringUtils.isEmpty(request.getParameter("MaxSqft"))) {
                query += "&maxsqft=" + request.getParameter("MaxSqft");
            }
            if (request.getParameter("ZipCode") != null && !StringUtils.isBlank(request.getParameter("ZipCode")) && !StringUtils.isWhitespace(request.getParameter("ZipCode")) && !StringUtils.isEmpty(request.getParameter("ZipCode"))) {
                query += "&postalCodes=" + request.getParameter("ZipCode");
            }

            HttpGet apirequest = new HttpGet(query);

            MaRestapiKeys maRestapiKeys = apiKeyService.GetApiKey(StatusEnums.ACTIVE.toString());
            String strcredentials = "";
            if (maRestapiKeys != null) {
                strcredentials = maRestapiKeys.getApikey() + ":" + maRestapiKeys.getApisecret();
            } else {
                strcredentials = "simplyrets:simplyrets";
            }

            byte[] credentials = strcredentials.getBytes();

            // add request header
            apirequest.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials));
            apirequest.addHeader("Accept", "application/json");

            HttpResponse response = client.execute(apirequest);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            List<RestProperty> property = new ArrayList<>();

            Type listType = new TypeToken<ArrayList<RestProperty>>() {
            }.getType();
            property = new Gson().fromJson(result.toString(), listType);

            property.forEach(m
                    -> {
                DecimalFormat decimalFormat = new DecimalFormat("##.00");
                NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
                m.setFormattedPrice("$" + nf.format(m.getListPrice()));
                if (m.getProperty().getArea() > 0) {
                    BigDecimal sqftprice = (new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128)).setScale(2, RoundingMode.HALF_UP);
                    m.setFormattedSqftPrice("$" + nf.format(sqftprice));
                }
            });

            model.addAttribute("homemodel", homeViewModel);

            homeViewModel.setList(property);

            // Gson gson = new Gson();

            ///  homeViewModel.setJsonlist(gson.toJson(homeViewModel.getList()));    ///(RestProperty) list to string
            // Gson gson2 = new Gson();
            List<Location> locationlist = new ArrayList<Location>();
            for (RestProperty item : homeViewModel.getList()) {
                Location location = new Location();
                location.setLat(item.getGeo().getLat());
                location.setLng(item.getGeo().getLng());
                location.setContent(item.getGeo().getMarketArea());
                locationlist.add(location);
            }
            //    homeViewModel.setLocationjson(gson2.toJson(locationlist));   ///(Location) list to string
            homeViewModel.setLocations(locationlist);
            String evalView = internalRenderer.evalView(request, mainresponse, model, locale, "PartialViews/HomePropertyList");

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IsSuccess", Boolean.TRUE);
            jsonObject.addProperty("list", homeViewModel.getOrgJsonlist());
            //  jsonObject.addProperty("view", evalView);

            // return jsonObject.toString();
            return ResponseEntity.ok(jsonObject);

        } catch (Exception ex) {
            //  Gson gson = new Gson();
            //   homeViewModel.setJsonlist(gson.toJson(new ArrayList<RestProperty>()));  ///(RestProperty) list to string
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IsSuccess", Boolean.FALSE);
            jsonObject.addProperty("Message", ex.getMessage());
            jsonObject.addProperty("list", homeViewModel.getOrgJsonlist());
            // jsonObject.addProperty("view", "");
            return ResponseEntity.ok(jsonObject);

        }

    }

    // This method is use to get properties by deal factor but now it's not used so you can ignore this
    @RequestMapping(value = "/GetPropertiesByDealPercentage", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity GetPropertiesByDealPercentage(Model model, HttpServletResponse mainresponse, HttpServletRequest request, Locale locale) throws Exception {
        HomeViewModel homeViewModel = new HomeViewModel();
        try {

            HttpClient client = HttpClientBuilder.create().build();

            if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) == null) {
                throw new UnAthorizedSiteAccessException("");
            }

            String query = StatusEnums.SIMPLYRETS_BASEAPI.toString() + "/properties?include=association&include=agreement&include=garageSpaces&include=maintenanceExpense&include=parking&include=pool&include=rooms&include=taxAnnualAmount&include=taxYear&count=true";

            final double Percentage = request.getParameter("Percentage") != null ? Double.parseDouble(request.getParameter("Percentage")) : 0;

            if (request.getParameter("Search") != null && !StringUtils.isBlank(request.getParameter("Search")) && !StringUtils.isWhitespace(request.getParameter("Search")) && !StringUtils.isEmpty(request.getParameter("Search"))) {
                query += "&q=" + request.getParameter("Search").replaceAll("\\s", "");
            }

            if (request.getParameter("PropertyType") != null && !StringUtils.isBlank(request.getParameter("PropertyType")) && !StringUtils.isWhitespace(request.getParameter("PropertyType")) && !StringUtils.isEmpty(request.getParameter("PropertyType"))) {
                query += "&type=" + request.getParameter("PropertyType");
            }

            if (request.getParameter("PropertySubType") != null && !StringUtils.isBlank(request.getParameter("PropertySubType")) && !StringUtils.isWhitespace(request.getParameter("PropertySubType")) && !StringUtils.isEmpty(request.getParameter("PropertySubType"))) {
                query += "&subtype=" + request.getParameter("PropertySubType");
            }

            if (request.getParameter("MinYear") != null && !StringUtils.isBlank(request.getParameter("MinYear")) && !StringUtils.isWhitespace(request.getParameter("MinYear")) && !StringUtils.isEmpty(request.getParameter("MinYear"))) {
                query += "&minyear=" + request.getParameter("MinYear");
            }

            if (request.getParameter("MaxYear") != null && !StringUtils.isBlank(request.getParameter("MaxYear")) && !StringUtils.isWhitespace(request.getParameter("MaxYear")) && !StringUtils.isEmpty(request.getParameter("MaxYear"))) {
                query += "&maxyear=" + request.getParameter("MaxYear");
            }

            if (request.getParameter("MinSqft") != null && !StringUtils.isBlank(request.getParameter("MinSqft")) && !StringUtils.isWhitespace(request.getParameter("MinSqft")) && !StringUtils.isEmpty(request.getParameter("MinSqft"))) {
                query += "&minarea=" + request.getParameter("MinSqft");
            }

            if (request.getParameter("MaxSqft") != null && !StringUtils.isBlank(request.getParameter("MaxSqft")) && !StringUtils.isWhitespace(request.getParameter("MaxSqft")) && !StringUtils.isEmpty(request.getParameter("MaxSqft"))) {
                query += "&maxarea=" + request.getParameter("MaxSqft");
            }

            if (request.getParameter("MinBaths") != null && !StringUtils.isBlank(request.getParameter("MinBaths")) && !StringUtils.isWhitespace(request.getParameter("MinBaths")) && !StringUtils.isEmpty(request.getParameter("MinBaths"))) {
                query += "&minbaths=" + request.getParameter("MinBaths");
            }

            if (request.getParameter("MaxBaths") != null && !StringUtils.isBlank(request.getParameter("MaxBaths")) && !StringUtils.isWhitespace(request.getParameter("MaxBaths")) && !StringUtils.isEmpty(request.getParameter("MaxBaths"))) {
                query += "&maxbaths=" + request.getParameter("MaxBaths");
            }

            if (request.getParameter("MinBeds") != null && !StringUtils.isBlank(request.getParameter("MinBeds")) && !StringUtils.isWhitespace(request.getParameter("MinBeds")) && !StringUtils.isEmpty(request.getParameter("MinBeds"))) {
                query += "&minbeds=" + request.getParameter("MinBeds");
            }

            if (request.getParameter("MaxBeds") != null && !StringUtils.isBlank(request.getParameter("MaxBeds")) && !StringUtils.isWhitespace(request.getParameter("MaxBeds")) && !StringUtils.isEmpty(request.getParameter("MaxBeds"))) {
                query += "&maxbeds=" + request.getParameter("MaxBeds");
            }

            if (request.getParameter("MinPrice") != null && !StringUtils.isBlank(request.getParameter("MinPrice")) && !StringUtils.isWhitespace(request.getParameter("MinPrice")) && !StringUtils.isEmpty(request.getParameter("MinPrice"))) {
                query += "&minprice=" + request.getParameter("MinPrice");
            }
            if (request.getParameter("MaxPrice") != null && !StringUtils.isBlank(request.getParameter("MaxPrice")) && !StringUtils.isWhitespace(request.getParameter("MaxPrice")) && !StringUtils.isEmpty(request.getParameter("MaxPrice"))) {
                query += "&maxprice=" + request.getParameter("MaxPrice");
            }

            HttpGet apirequest = new HttpGet(query);
            MaRestapiKeys maRestapiKeys = apiKeyService.GetApiKey(StatusEnums.ACTIVE.toString());
            String strcredentials = "";
            if (maRestapiKeys != null) {
                strcredentials = maRestapiKeys.getApikey() + ":" + maRestapiKeys.getApisecret();
            } else {
                strcredentials = "simplyrets:simplyrets";
            }

            byte[] credentials = strcredentials.getBytes();

            // add request header
            apirequest.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials));
            apirequest.addHeader("Accept", "application/json");

            HttpResponse response = client.execute(apirequest);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            List<RestProperty> property = new ArrayList<>();

            Type listType = new TypeToken<ArrayList<RestProperty>>() {
            }.getType();
            property = new Gson().fromJson(result.toString(), listType);

//        if (property.size() > 0) {
//            DecimalFormat decimalFormat = new DecimalFormat("##.00");
//            homeViewModel.setAverage(new BigDecimal(property.stream().mapToInt(i -> i.getListPrice()).average().getAsDouble()));
//            homeViewModel.setAverageRent(new BigDecimal(property.stream().mapToDouble(i -> Math.round(Double.parseDouble(decimalFormat.format(i.getListPrice() * 0.01)))).average().getAsDouble()));
//
//        }
            property.forEach(m
                    -> {
                DecimalFormat decimalFormat = new DecimalFormat("##.00");
                NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
                List<RestProperty> list = new ArrayList<RestProperty>();
                try {
                    list = SearchPropertyByZipCode(m.getMlsId(), m.getAddress().getPostalCode(), m.getGeo().getLat(), m.getGeo().getLng(), m.getProperty().getType(), m.getProperty().getSubType(), m.getProperty().getArea(), m.getProperty().getYearBuilt(), m.getProperty().getBedrooms(), request, "Active");
                } catch (IOException ex) {

                }
                BigDecimal avg = GetAverageOfPricePerArea(list, "Active");
                if (avg.compareTo(new BigDecimal(0)) == 1) {
                    //BigDecimal dealpercentage = (avg.subtract(new BigDecimal(m.getListPrice()))).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                    BigDecimal dealpercentage = (new BigDecimal(m.getListPrice()).subtract(avg.multiply(new BigDecimal(m.getProperty().getArea())))).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                    m.setDealPercentage(dealpercentage.compareTo(new BigDecimal(0)) == -1 ? new BigDecimal(0) : dealpercentage);
                    //m.setDealPercentage((avg.subtract(new BigDecimal(m.getListPrice())).divide(avg, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100))).setScale(2, RoundingMode.HALF_UP).compareTo(new BigDecimal(0)) == -1 ? new BigDecimal(0) : (avg.subtract(new BigDecimal(m.getListPrice())).divide(avg, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100))).setScale(2, RoundingMode.HALF_UP));
                } else {
                    m.setDealPercentage(new BigDecimal(0));
                }
                m.setFormattedPrice("$" + nf.format(m.getListPrice()));
                if (m.getProperty().getArea() > 0) {
                    BigDecimal sqftprice = (new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128)).setScale(2, RoundingMode.HALF_UP);
                    m.setFormattedSqftPrice("$" + nf.format(sqftprice));
                    //m.setFormattedSqftPrice("$" + nf.format(Double.parseDouble(decimalFormat.format(Math.round(m.getListPrice() / m.getProperty().getArea())))));
                }

                m.setRentPrice(avg);
                m.setFormattedRentPrice("$" + nf.format(Double.parseDouble(decimalFormat.format(Math.round(m.getListPrice() * 0.01)))));
            });

            List<RestProperty> filteredpropList = property.stream().filter(empl -> empl.getDealPercentage().doubleValue() >= Percentage).collect(Collectors.toList());

            homeViewModel.setList(filteredpropList);

            //  Gson gson = new Gson();

            //   homeViewModel.setJsonlist(gson.toJson(homeViewModel.getList()));    ///(RestProperty) list to string
            //  Gson gson2 = new Gson();
            List<Location> locationlist = new ArrayList<Location>();
            for (RestProperty item : homeViewModel.getList()) {
                Location location = new Location();
                location.setLat(item.getGeo().getLat());
                location.setLng(item.getGeo().getLng());
                location.setContent(item.getGeo().getMarketArea());
                locationlist.add(location);
            }
            homeViewModel.setLocations(locationlist);
            ///  homeViewModel.setLocationjson(gson2.toJson(locationlist));  ///(Location) list to string

            model.addAttribute("homemodel", homeViewModel);

            String evalView = internalRenderer.evalView(request, mainresponse, model, locale, "PartialViews/HomePropertyList");

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IsSuccess", Boolean.TRUE);
            jsonObject.addProperty("list", homeViewModel.getOrgJsonlist());
            // jsonObject.addProperty("view", evalView);

            //return StringEscapeUtils.escapeJson(jsonObject.toString());
            return ResponseEntity.ok(jsonObject);
        } catch (Exception ex) {
            //   Gson gson = new Gson();
            //  homeViewModel.setJsonlist(gson.toJson(new ArrayList<RestProperty>()));
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IsSuccess", Boolean.FALSE);
            jsonObject.addProperty("Message", ex.getMessage());
            jsonObject.addProperty("list", homeViewModel.getOrgJsonlist());
            //  jsonObject.addProperty("view", "");
            return ResponseEntity.ok(jsonObject);
        }

    }

    @RequestMapping(value = "/PropertyDetails/{PropertyID}", method = RequestMethod.GET)
    //This method is for property details page
    public ResponseEntity PropertyDetails(Model model, HttpServletRequest request, @PathVariable Long PropertyID) throws IOException, UnAthorizedSiteAccessException {
        HomeViewModel homeViewModel = new HomeViewModel();
        try {
            String StatusForDealCalculation = "Closed";
            MaUserPreferences maUserPreferences = null;
            if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) == null) {
                throw new UnAthorizedSiteAccessException("");
            }
            if (sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()) != null) {
                maUserPreferences = preferencesService.Select_MA_User_Preferences_By_UserID(Long.parseLong(sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()).toString()), StatusEnums.ACTIVE.toString());
            }
            MaDealCalculation dealCalculation = null;
            BigDecimal avgMonthlyRentPrice = new BigDecimal(BigInteger.ZERO);
            BigDecimal avgDealPrice = new BigDecimal(BigInteger.ZERO);
            List<RestProperty> monthlyRentProperties = new ArrayList<>();
            List<RestProperty> dealCalculationProperties = new ArrayList<>();
            RestProperty restProperty = GetPropertyDetailsByID(PropertyID);
            System.out.println("Actual Propery Price : " + restProperty.getListPricePerArea());
            homeViewModel.setPropertyDetails(restProperty);
            //   Gson gson = new Gson();
            if (restProperty != null && !restProperty.isIsError()) {
                LocalDate enddate = LocalDate.now();
                LocalDate startdate = LocalDate.now().minusYears(5);
                System.out.println("Start Date Raw :" + startdate);
                String start_date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(startdate) + "T00:00:00.000Z";
                System.out.println("Start Date Formatted :" + startdate);

                String end_date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(enddate) + "T00:00:00.000Z";
                if (restProperty.getGeo() != null) {
                    CrimeDetails crimeDetailses = GetCrimeListByLatAndLong(restProperty.getGeo().getLat(), restProperty.getGeo().getLng(), start_date, end_date, request);
                    if (crimeDetailses != null) {
                        homeViewModel.setCrimeApiError(crimeDetailses.getError());
                        List<CrimeIncedents> incidents = crimeDetailses.getIncidents();
                        if (incidents == null) {
                            incidents = new ArrayList<CrimeIncedents>();
                        }
                        CrimeIncedents crimeIncedents = new CrimeIncedents();
                        crimeIncedents.setIsHome(true);
                        model.addAttribute("homelat", restProperty.getGeo().getLat());
                        model.addAttribute("homelng", restProperty.getGeo().getLng());
                        crimeIncedents.setIncident_latitude(restProperty.getGeo().getLat());
                        crimeIncedents.setIncident_longitude(restProperty.getGeo().getLng());
                        incidents.add(crimeIncedents);
                        homeViewModel.setCrimeIncedents(incidents);
                        // homeViewModel.setCrimejsonlist(gson.toJson(incidents));    <CrimeIncedents> list to string
                    }
                }

                restProperty.setIsActive(true);

                NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
                restProperty.setFormattedPrice("$" + nf.format(restProperty.getListPrice()));

                if (restProperty.getProperty().getType() != null && !restProperty.getProperty().getType().equalsIgnoreCase("RNT")) {

                    if (restProperty.getAddress() != null && restProperty.getGeo() != null && restProperty.getProperty() != null) {
                        monthlyRentProperties = SearchPropertyByZipCode(restProperty.getMlsId(), restProperty.getAddress().getPostalCode(), restProperty.getGeo().getLat(), restProperty.getGeo().getLng(), "RNT", restProperty.getProperty().getSubType(), restProperty.getProperty().getArea(), restProperty.getProperty().getYearBuilt(), restProperty.getProperty().getBedrooms(), request, "Active");
                        dealCalculationProperties = SearchPropertyByZipCode(restProperty.getMlsId(), restProperty.getAddress().getPostalCode(), restProperty.getGeo().getLat(), restProperty.getGeo().getLng(), restProperty.getProperty().getType(), restProperty.getProperty().getSubType(), restProperty.getProperty().getArea(), restProperty.getProperty().getYearBuilt(), restProperty.getProperty().getBedrooms(), request, StatusForDealCalculation);
                    }

                    System.out.println("Avg Rent Property : " + monthlyRentProperties.size());
                    System.out.println("Deal calculation : " + dealCalculationProperties.size());


                    avgMonthlyRentPrice = GetAverageOfPricePerArea(monthlyRentProperties, "Active");


                    System.out.println("Average Rent : " + avgMonthlyRentPrice);


                    dealCalculationProperties.stream().forEach(m -> System.out.println(" Sold Property :" + m.getClosePricePerArea() + "Distance : " + m.getDistance()));
                    dealCalculationProperties.stream().forEach(m -> System.out.println(" Active Property :" + m.getListPricePerArea() + "Distance : " + m.getDistance()));

                    //Consider only closed property which has closed price
                    List<RestProperty> closedPropertysForDealFactor = new ArrayList<>();
                    if (StatusForDealCalculation.equalsIgnoreCase("Active")) {
                        closedPropertysForDealFactor = dealCalculationProperties.stream()
                                .filter(m -> m.getListPricePerArea().compareTo(new BigDecimal(0)) == 1)
                                .collect(Collectors.toList());
                    } else {
                        closedPropertysForDealFactor = dealCalculationProperties.stream()
                                .filter(m -> m.getClosePricePerArea().compareTo(new BigDecimal(0)) == 1)
                                .collect(Collectors.toList());
                    }

                    // Per Sq feet
                    avgDealPrice = GetAverageOfPricePerArea(closedPropertysForDealFactor, StatusForDealCalculation);
                    //avgDealPrice = GetAverageOfPricePerArea(dealCalculationProperties, "Active");

                    //dealCalculationProperties.add(restProperty);
                    closedPropertysForDealFactor.add(restProperty);

                    monthlyRentProperties.add(restProperty);

                    //homeViewModel.setDealPropertylist(dealCalculationProperties);
                    homeViewModel.setDealPropertylist(closedPropertysForDealFactor);

                    //  homeViewModel.setJsonlist(gson.toJson(homeViewModel.getDealPropertylist()));   // <property> list to string
                    homeViewModel.setMonthlyRentPropertylist(monthlyRentProperties);
                    //  homeViewModel.setMonthlyrentjsonlist(gson.toJson(homeViewModel.getMonthlyRentPropertylist()));        // <property> list to string
                    //

                    if (avgDealPrice.multiply(new BigDecimal(restProperty.getProperty() == null ? 0 : restProperty.getProperty().getArea()))
                            .compareTo(new BigDecimal(0)) == -1 || avgDealPrice
                            .multiply(new BigDecimal(restProperty.getProperty() == null ? 0 : restProperty.getProperty().getArea()))
                            .compareTo(new BigDecimal(0)) == 0) {
                        homeViewModel.setDealPercentage("Not Available");
                    } else {
                        // this will give total average price
                        BigDecimal TotalAvgPrice = avgDealPrice.multiply(new BigDecimal(restProperty.getProperty() == null ? 0 : restProperty.getProperty().getArea()));
                        System.out.println("Total Avg Price : " + TotalAvgPrice);

                        BigDecimal diff = (TotalAvgPrice).subtract(new BigDecimal(restProperty.getListPrice()));
                        System.out.println("Difference :" + diff);

                        BigDecimal divisionResult = diff.divide(TotalAvgPrice, MathContext.DECIMAL128);

                        System.out.println("Division Result : " + divisionResult);

                        BigDecimal dealpercentage = divisionResult.multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);

                        System.out.println("Deal Percentage : " + dealpercentage);

                        homeViewModel.setDealPercentage((dealpercentage.compareTo(new BigDecimal(0)) == -1 ? new BigDecimal(0) : dealpercentage).toString() + "%");
                    }

                    homeViewModel.setMonthlyRent(avgMonthlyRentPrice.multiply(new BigDecimal(restProperty.getProperty().getArea())));

                    if (sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()) == null) {

                        homeViewModel.setHomePrice(new BigDecimal(homeViewModel.getPropertyDetails().getListPrice()).setScale(2, RoundingMode.HALF_UP));

                        if (maUserPreferences != null) {
                            if (maUserPreferences.getDownpaymentpercentage() != null) {
                                homeViewModel.setDownPaymentPercentage(maUserPreferences.getDownpaymentpercentage().setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setDownPayment(homeViewModel.getHomePrice().multiply((maUserPreferences.getDownpaymentpercentage().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP))).setScale(2, RoundingMode.HALF_UP));
                            } else {
                                homeViewModel.setDownPaymentPercentage(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setDownPayment(homeViewModel.getHomePrice().multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP));
                            }
                            if (maUserPreferences.getInterestratepercentage() != null) {
                                homeViewModel.setInterestRate(maUserPreferences.getInterestratepercentage().setScale(2, RoundingMode.HALF_UP));
                            } else {
                                homeViewModel.setInterestRate(new BigDecimal(4).setScale(2, RoundingMode.HALF_UP));
                            }
                            if (maUserPreferences.getHomeinsurancepercentage() != null) {
                                homeViewModel.setHomeInsurancePercentage(maUserPreferences.getHomeinsurancepercentage().setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setHomeInsurance(homeViewModel.getHomePrice().multiply((maUserPreferences.getHomeinsurancepercentage().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP))).setScale(2, RoundingMode.HALF_UP));
                            } else {
                                homeViewModel.setHomeInsurancePercentage(new BigDecimal(0.8));
                                homeViewModel.setHomeInsurance(homeViewModel.getHomePrice().multiply(new BigDecimal(0.008)).setScale(2, RoundingMode.HALF_UP));
                            }
                            homeViewModel.setMortageInsurance(maUserPreferences.getMortageinsurance() == null ? new BigDecimal(0) : maUserPreferences.getMortageinsurance().setScale(2, RoundingMode.HALF_UP));
                        } else {
                            homeViewModel.setDownPaymentPercentage(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setDownPayment(homeViewModel.getHomePrice().multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setInterestRate(new BigDecimal(4).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setHomeInsurancePercentage(new BigDecimal(0.8));
                            homeViewModel.setHomeInsurance(homeViewModel.getHomePrice().multiply(new BigDecimal(0.008)).setScale(2, RoundingMode.HALF_UP));
                        }

                        if (homeViewModel.getPropertyDetails() != null && homeViewModel.getPropertyDetails().getTax() != null) {
                            homeViewModel.setPropertyTax(new BigDecimal(homeViewModel.getPropertyDetails().getTax().getTaxAnnualAmount()).setScale(2, RoundingMode.HALF_UP));
                            if (homeViewModel.getHomePrice().compareTo(new BigDecimal(0)) == 1) {
                                BigDecimal taxpercent = (homeViewModel.getPropertyTax().divide(homeViewModel.getHomePrice(), MathContext.DECIMAL128)).multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
                                homeViewModel.setPropertyTaxPercentage(taxpercent);
                            } else {
                                homeViewModel.setPropertyTaxPercentage(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                            }

                        } else {
                            homeViewModel.setPropertyTax(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setPropertyTaxPercentage(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                        }
//            if (homeViewModel.getPropertyDetails().getAssociation() != null) {
//                homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getAssociation().getFee()).setScale(2, RoundingMode.HALF_UP));
//            } else {
//                homeViewModel.setHoaDues(new BigDecimal(0));
//            }

                        if (homeViewModel.getPropertyDetails() != null && homeViewModel.getPropertyDetails().getProperty() != null && homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense() != null) {

                            if (homeViewModel.getPropertyDetails().getProperty().getSubType() != null && (homeViewModel.getPropertyDetails().getProperty().getSubType().equalsIgnoreCase("Condominium") || homeViewModel.getPropertyDetails().getProperty().getSubType().equalsIgnoreCase("Townhouse"))) {
                                homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense().toString()).setScale(2, RoundingMode.HALF_UP));
                            } else {
                                homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense().toString()).divide(new BigDecimal(12), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
                            }

                        } else {
                            homeViewModel.setHoaDues(new BigDecimal(0));
                        }

                        homeViewModel.setPurchasePricePercentage(new BigDecimal(2));
                        homeViewModel.setPurchasePrice(homeViewModel.getHomePrice().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP));
                        homeViewModel.setMonthlyCapReservPercentage(new BigDecimal(2));
                        homeViewModel.setMonthlyCapReserv(homeViewModel.getMonthlyRent().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP));
                        homeViewModel.setMaintainancePercentage(new BigDecimal(2));
                        homeViewModel.setMaintainance(homeViewModel.getMonthlyRent().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP));
                        homeViewModel.setAfterRepairValue(homeViewModel.getHomePrice().setScale(2, RoundingMode.HALF_UP));
                    } else {
                        dealCalculation = dealCalculationService.Select_MA_Property_Calculation_By_PropertyID(PropertyID, Long.parseLong(sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()).toString()), StatusEnums.ACTIVE.toString());
                        if (dealCalculation != null) {

                            homeViewModel.setHomePrice(dealCalculation.getHomeprice() == null ? new BigDecimal(homeViewModel.getPropertyDetails().getListPrice()).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getHomeprice());

                            homeViewModel.setDownPaymentPercentage(dealCalculation.getDownpaymentpercentage() == null ? new BigDecimal(20).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getDownpaymentpercentage());

                            homeViewModel.setDownPayment(dealCalculation.getDownpayment() == null ? homeViewModel.getHomePrice().multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getDownpayment());

                            homeViewModel.setInterestRate(dealCalculation.getInterestrate() == null ? new BigDecimal(4).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getInterestrate());

                            if (dealCalculation.getPropertytax() == null) {
                                if (homeViewModel.getPropertyDetails() != null && homeViewModel.getPropertyDetails().getTax() != null) {
                                    homeViewModel.setPropertyTax(new BigDecimal(homeViewModel.getPropertyDetails().getTax().getTaxAnnualAmount()).setScale(2, RoundingMode.HALF_UP));
                                    if (homeViewModel.getHomePrice().compareTo(new BigDecimal(0)) == 1) {
                                        BigDecimal taxpercent = (homeViewModel.getPropertyTax().divide(homeViewModel.getHomePrice(), MathContext.DECIMAL128)).multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
                                        homeViewModel.setPropertyTaxPercentage(taxpercent);
                                    } else {
                                        homeViewModel.setPropertyTaxPercentage(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                                    }

                                } else {
                                    homeViewModel.setPropertyTax(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                                    homeViewModel.setPropertyTaxPercentage(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                                }
                            } else {
                                homeViewModel.setPropertyTax(dealCalculation.getPropertytax());
                                homeViewModel.setPropertyTaxPercentage(dealCalculation.getPropertytaxpercentage() == null ? new BigDecimal(0) : dealCalculation.getPropertytaxpercentage());
                            }

                            if (dealCalculation.getHoadues() == null) {
                                if (homeViewModel.getPropertyDetails() != null && homeViewModel.getPropertyDetails().getProperty() != null && homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense() != null) {

                                    if (homeViewModel.getPropertyDetails().getProperty().getSubType() != null && (homeViewModel.getPropertyDetails().getProperty().getSubType().equalsIgnoreCase("Condominium") || homeViewModel.getPropertyDetails().getProperty().getSubType().equalsIgnoreCase("Townhouse"))) {
                                        homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense().toString()).setScale(2, RoundingMode.HALF_UP));
                                    } else {
                                        homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense().toString()).divide(new BigDecimal(12), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
                                    }

                                } else {
                                    homeViewModel.setHoaDues(new BigDecimal(0));
                                }
//                    if (homeViewModel.getPropertyDetails().getAssociation() != null) {
//                        homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getAssociation().getFee()).setScale(2, RoundingMode.HALF_UP));
//                    } else {
//                        homeViewModel.setHoaDues(new BigDecimal(0));
//                    }
                            } else {
                                homeViewModel.setHoaDues(dealCalculation.getHoadues());
                            }

                            homeViewModel.setMonthlyRent(dealCalculation.getMonthlyrent() == null ? avgMonthlyRentPrice : dealCalculation.getMonthlyrent());

                            homeViewModel.setLoanType(dealCalculation.getLoantype() == null ? 30L : dealCalculation.getLoantype());

                            homeViewModel.setMortageInsurance(dealCalculation.getMortageinsurance() == null ? new BigDecimal(BigInteger.ZERO) : dealCalculation.getMortageinsurance());

                            homeViewModel.setAfterRepairValue(dealCalculation.getAfterrepairvalue() == null ? homeViewModel.getHomePrice() : dealCalculation.getAfterrepairvalue());

                            homeViewModel.setRehabCost(dealCalculation.getRehabcost() == null ? new BigDecimal(BigInteger.ZERO) : dealCalculation.getRehabcost());

                            homeViewModel.setPurchasePrice(dealCalculation.getPurchaseprice() == null ? homeViewModel.getHomePrice().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getPurchaseprice());

                            homeViewModel.setPurchasePricePercentage(dealCalculation.getPurchasepricepercentage() == null ? new BigDecimal(2) : dealCalculation.getPurchasepricepercentage());

                            homeViewModel.setMonthlyCapReserv(dealCalculation.getMonthlycapreserv() == null ? homeViewModel.getMonthlyRent().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getMonthlycapreserv());

                            homeViewModel.setMonthlyCapReservPercentage(dealCalculation.getMonthlycapreservpercentage() == null ? new BigDecimal(2) : dealCalculation.getMonthlycapreservpercentage());

                            homeViewModel.setMaintainance(dealCalculation.getMaintainance() == null ? homeViewModel.getMonthlyRent().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getMaintainance());

                            homeViewModel.setMaintainancePercentage(dealCalculation.getMaintainancepercentage() == null ? new BigDecimal(2) : dealCalculation.getMaintainancepercentage());

                            homeViewModel.setPropertyManagement(dealCalculation.getPropertymanagement() == null ? new BigDecimal(BigInteger.ZERO) : dealCalculation.getPropertymanagement());

                            homeViewModel.setVacancyrate(dealCalculation.getVacancyrate() == null ? new BigDecimal(BigInteger.ZERO) : dealCalculation.getVacancyrate());

                            homeViewModel.setOtherMonthlyCost(dealCalculation.getOthermonthlycost() == null ? new BigDecimal(BigInteger.ZERO) : dealCalculation.getOthermonthlycost());

                            homeViewModel.setCreditScore(dealCalculation.getCreditscore() == null ? 670L : dealCalculation.getCreditscore());

                            homeViewModel.setHomeInsurance(dealCalculation.getHomeinsurance() == null ? homeViewModel.getHomePrice().multiply(new BigDecimal(0.008)).setScale(2, RoundingMode.HALF_UP) : dealCalculation.getHomeinsurance());

                            homeViewModel.setHomeInsurancePercentage(dealCalculation.getHomeinsurancepercentage() == null ? new BigDecimal(0.8) : dealCalculation.getHomeinsurancepercentage());

                        } else {
                            homeViewModel.setHomePrice(new BigDecimal(homeViewModel.getPropertyDetails().getListPrice()).setScale(2, RoundingMode.HALF_UP));

                            if (maUserPreferences != null) {
                                if (maUserPreferences.getDownpaymentpercentage() != null) {
                                    homeViewModel.setDownPaymentPercentage(maUserPreferences.getDownpaymentpercentage().setScale(2, RoundingMode.HALF_UP));
                                    homeViewModel.setDownPayment(homeViewModel.getHomePrice().multiply((maUserPreferences.getDownpaymentpercentage().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP))).setScale(2, RoundingMode.HALF_UP));
                                } else {
                                    homeViewModel.setDownPaymentPercentage(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP));
                                    homeViewModel.setDownPayment(homeViewModel.getHomePrice().multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP));
                                }
                                if (maUserPreferences.getInterestratepercentage() != null) {
                                    homeViewModel.setInterestRate(maUserPreferences.getInterestratepercentage().setScale(2, RoundingMode.HALF_UP));
                                } else {
                                    homeViewModel.setInterestRate(new BigDecimal(4).setScale(2, RoundingMode.HALF_UP));
                                }
                                if (maUserPreferences.getHomeinsurancepercentage() != null) {
                                    homeViewModel.setHomeInsurancePercentage(maUserPreferences.getHomeinsurancepercentage().setScale(2, RoundingMode.HALF_UP));
                                    homeViewModel.setHomeInsurance(homeViewModel.getHomePrice().multiply((maUserPreferences.getHomeinsurancepercentage().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP))).setScale(2, RoundingMode.HALF_UP));
                                } else {
                                    homeViewModel.setHomeInsurancePercentage(new BigDecimal(0.8));
                                    homeViewModel.setHomeInsurance(homeViewModel.getHomePrice().multiply(new BigDecimal(0.008)).setScale(2, RoundingMode.HALF_UP));
                                }
                                homeViewModel.setMortageInsurance(maUserPreferences.getMortageinsurance() == null ? new BigDecimal(0) : maUserPreferences.getMortageinsurance().setScale(2, RoundingMode.HALF_UP));
                            } else {
                                homeViewModel.setDownPaymentPercentage(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setDownPayment(homeViewModel.getHomePrice().multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setInterestRate(new BigDecimal(4).setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setHomeInsurancePercentage(new BigDecimal(0.8));
                                homeViewModel.setHomeInsurance(homeViewModel.getHomePrice().multiply(new BigDecimal(0.008)).setScale(2, RoundingMode.HALF_UP));
                            }

                            if (homeViewModel.getPropertyDetails() != null && homeViewModel.getPropertyDetails().getTax() != null) {
                                homeViewModel.setPropertyTax(new BigDecimal(homeViewModel.getPropertyDetails().getTax().getTaxAnnualAmount()).setScale(2, RoundingMode.HALF_UP));
                                if (homeViewModel.getHomePrice().compareTo(new BigDecimal(0)) == 1) {
                                    BigDecimal taxpercent = (homeViewModel.getPropertyTax().divide(homeViewModel.getHomePrice(), MathContext.DECIMAL128)).multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
                                    homeViewModel.setPropertyTaxPercentage(taxpercent);
                                } else {
                                    homeViewModel.setPropertyTaxPercentage(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                                }

                            } else {
                                homeViewModel.setPropertyTax(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                                homeViewModel.setPropertyTaxPercentage(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP));
                            }

                            if (homeViewModel.getPropertyDetails() != null && homeViewModel.getPropertyDetails().getProperty() != null && homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense() != null) {

                                if (homeViewModel.getPropertyDetails().getProperty().getSubType() != null && (homeViewModel.getPropertyDetails().getProperty().getSubType().equalsIgnoreCase("Condominium") || homeViewModel.getPropertyDetails().getProperty().getSubType().equalsIgnoreCase("Townhouse"))) {
                                    homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense().toString()).setScale(2, RoundingMode.HALF_UP));
                                } else {
                                    homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getProperty().getMaintenanceExpense().toString()).divide(new BigDecimal(12), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
                                }
                            } else {
                                homeViewModel.setHoaDues(new BigDecimal(0));
                            }

//                if (homeViewModel.getPropertyDetails().getAssociation() != null) {
//                    homeViewModel.setHoaDues(new BigDecimal(homeViewModel.getPropertyDetails().getAssociation().getFee()).setScale(2, RoundingMode.HALF_UP));
//                } else {
//                    homeViewModel.setHoaDues(new BigDecimal(0));
//                }
                            homeViewModel.setPurchasePricePercentage(new BigDecimal(2));
                            homeViewModel.setPurchasePrice(homeViewModel.getHomePrice().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setMonthlyCapReservPercentage(new BigDecimal(2));
                            homeViewModel.setMonthlyCapReserv(homeViewModel.getMonthlyRent().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setMaintainancePercentage(new BigDecimal(2));
                            homeViewModel.setMaintainance(homeViewModel.getMonthlyRent().multiply(new BigDecimal(0.02)).setScale(2, RoundingMode.HALF_UP));
                            homeViewModel.setAfterRepairValue(homeViewModel.getHomePrice().setScale(2, RoundingMode.HALF_UP));
                        }

                    }

                } else {
                    dealCalculationProperties.add(restProperty);
                    homeViewModel.setDealPropertylist(dealCalculationProperties);
                    //  homeViewModel.setJsonlist(gson.toJson(homeViewModel.getDealPropertylist()));
                }

            } else {
                homeViewModel.setHasError(true);
                homeViewModel.setError(restProperty.getError());
            }
        } catch (Exception ex) {
            homeViewModel.setHasError(true);
            homeViewModel.setError(ex.getMessage());
        }

        // model.addAttribute("homemodel", homeViewModel);

        return ResponseEntity.ok(homeViewModel);

    }

    // this method is used to save the deal calculator details user wise
    @RequestMapping(value = "/SaveCalculatorDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity SaveCalculatorDetails(Model model, @ModelAttribute HomeViewModel home, HttpServletResponse mainresponse, HttpServletRequest request, Locale locale) throws Exception {

        try {
            if (sessionUtils.getSessionValue(request, StatusEnums.ISALLOWED_KEY.toString()) == null) {
                throw new UnAthorizedSiteAccessException("");
            }
            boolean isNew = true;
            if (sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()) == null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("IsSuccess", Boolean.FALSE);
                jsonObject.addProperty("AuthenticationError", Boolean.TRUE);
                jsonObject.addProperty("Message", "Calculation details has been saved successfully");
                return ResponseEntity.ok(jsonObject);
            }
            MaDealCalculation dealCalculation = new MaDealCalculation();
            if (home.getPropertyID() != null) {
                dealCalculation = dealCalculationService.Select_MA_Property_Calculation_By_PropertyID(home.getPropertyID(), Long.parseLong(sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()).toString()), StatusEnums.ACTIVE.toString());
                if (dealCalculation == null) {
                    dealCalculation = new MaDealCalculation();
                }

            }

            RestProperty propdetails = GetPropertyDetailsByID(home.getPropertyID());
            if (propdetails != null && !propdetails.isIsError()) {

                home.setAddress(propdetails.getAddress().getFull() + ", " + propdetails.getAddress().getCity() + ", " + propdetails.getAddress().getState() + ", " + propdetails.getAddress().getCountry());
                home.setBaths(Long.valueOf(propdetails.getProperty().getBathsFull()));
                home.setBeds(Long.valueOf(propdetails.getProperty().getBedrooms()));
                home.setPrice(BigDecimal.valueOf(propdetails.getListPrice()));
                home.setAreaSqft(Long.valueOf(propdetails.getProperty().getArea()));
            }
            BigDecimal downpayment_percentage = new BigDecimal(0);
            BigDecimal propertytax_percentage = new BigDecimal(0);
            BigDecimal insurance_percentage = new BigDecimal(0);
            BigDecimal purchaseprice_percentage = new BigDecimal(0);
            if (home.getHomePrice().compareTo(new BigDecimal(0)) == 1) {
                downpayment_percentage = ((home.getDownPayment().multiply(new BigDecimal(100))).divide(home.getHomePrice(), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
                propertytax_percentage = ((home.getPropertyTax().multiply(new BigDecimal(100))).divide(home.getHomePrice(), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
                insurance_percentage = ((home.getHomeInsurance().multiply(new BigDecimal(100))).divide(home.getHomePrice(), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
                purchaseprice_percentage = ((home.getPurchasePrice().multiply(new BigDecimal(100))).divide(home.getHomePrice(), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
            }
            home.setDownPaymentPercentage(downpayment_percentage);
            home.setPropertyTaxPercentage(propertytax_percentage);
            home.setHomeInsurancePercentage(insurance_percentage);
            home.setPurchasePricePercentage(purchaseprice_percentage);

            BigDecimal monthly_capreserv_percentage = new BigDecimal(0);
            BigDecimal maintainance_percentage = new BigDecimal(0);
            if (home.getMonthlyRent().compareTo(new BigDecimal(0)) == 1) {
                monthly_capreserv_percentage = ((home.getMonthlyCapReserv().multiply(new BigDecimal(100))).divide(home.getMonthlyRent(), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
                maintainance_percentage = ((home.getMaintainance().multiply(new BigDecimal(100))).divide(home.getMonthlyRent(), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
            }
            home.setMonthlyCapReservPercentage(monthly_capreserv_percentage);
            home.setMaintainancePercentage(maintainance_percentage);

            BigDecimal principal_amount = (home.getHomePrice().subtract(home.getDownPayment()));
            home.setPrincipalAmount(principal_amount);

            BigDecimal interest_amount = (((home.getInterestRate().divide(new BigDecimal(100), MathContext.DECIMAL128)).divide(new BigDecimal(12), MathContext.DECIMAL128)));
            home.setInterestAmount(interest_amount);

            BigDecimal noofpayments = new BigDecimal(home.getLoanType() * 12);
            home.setNoOfPayments(noofpayments);

            BigDecimal x = (home.getInterestAmount().add(new BigDecimal(1))).pow(home.getNoOfPayments().intValue()).setScale(1, RoundingMode.HALF_UP);

            BigDecimal monthly_payment = new BigDecimal(0);
            if (x.subtract(new BigDecimal(1)).compareTo(new BigDecimal(0)) == 1) {
                monthly_payment = home.getPrincipalAmount().multiply(x).multiply(home.getInterestAmount()).divide(x.subtract(new BigDecimal(1)), MathContext.DECIMAL128).setScale(1, RoundingMode.HALF_UP);
            }
            home.setMonthlyPayment(monthly_payment);

            BigDecimal cash_needed = home.getDownPayment().add(home.getPurchasePrice()).add(home.getRehabCost()).setScale(1, RoundingMode.HALF_UP);
            home.setCashNeeded(cash_needed);

            BigDecimal current_price = new BigDecimal(0);
            BigDecimal after_repair_value = new BigDecimal(0);
            if (home.getAreaSqft() > 0) {
                current_price = home.getHomePrice().divide(new BigDecimal(home.getAreaSqft()), MathContext.DECIMAL128).setScale(1, RoundingMode.HALF_UP);
                after_repair_value = home.getAfterRepairValue().divide(new BigDecimal(home.getAreaSqft()), MathContext.DECIMAL128).setScale(1, RoundingMode.HALF_UP);
            }
            home.setCurrentPrice(current_price);
            home.setAfterRepairPrice(after_repair_value);

            BigDecimal monthly_rent = home.getMonthlyRent().subtract((home.getMonthlyRent().multiply(home.getVacancyrate().divide(new BigDecimal(100), MathContext.DECIMAL128)))).setScale(1, RoundingMode.HALF_UP);
            home.setOperatingIncome(monthly_rent);

            BigDecimal totalinsurances = (home.getPropertyTax().add(home.getHomeInsurance()).add(home.getMortageInsurance())).divide(new BigDecimal(12), MathContext.DECIMAL128).setScale(1, RoundingMode.HALF_UP);

            BigDecimal property_management = home.getPropertyManagement().divide(new BigDecimal(100), MathContext.DECIMAL128).multiply(home.getMonthlyRent()).setScale(1, RoundingMode.HALF_UP);

            BigDecimal operating_expenses = totalinsurances.add(home.getHoaDues()).add(home.getMonthlyCapReserv()).add(home.getMaintainance()).add(property_management).add(home.getOtherMonthlyCost());
            home.setOperatingExpenses(operating_expenses);

            BigDecimal net_operating_income = home.getOperatingIncome().subtract(home.getOperatingExpenses()).setScale(1, RoundingMode.HALF_UP);
            home.setNetOperatingIncome(net_operating_income);

            BigDecimal cash_flow = home.getNetOperatingIncome().subtract(home.getMonthlyPayment()).setScale(1, RoundingMode.HALF_UP);
            home.setCashFlow(cash_flow);

            BigDecimal purchase_pricecap_rate = new BigDecimal(0);
            if (home.getHomePrice().compareTo(new BigDecimal(0)) == 1) {
                purchase_pricecap_rate = ((home.getNetOperatingIncome().multiply(new BigDecimal(12))).divide(home.getHomePrice(), MathContext.DECIMAL128).multiply(new BigDecimal(100))).setScale(1, RoundingMode.HALF_UP);
            }
            home.setPurchasePriceCapRate(purchase_pricecap_rate);

            BigDecimal market_value_caprate = new BigDecimal(0);
            if (home.getAfterRepairValue().compareTo(new BigDecimal(0)) == 1) {
                market_value_caprate = ((home.getNetOperatingIncome().multiply(new BigDecimal(12))).divide(home.getAfterRepairValue(), MathContext.DECIMAL128).multiply(new BigDecimal(100))).setScale(1, RoundingMode.HALF_UP);
            }
            home.setMarketValueCapRate(market_value_caprate);

            BigDecimal cash_on_cash = new BigDecimal(0);
            if (home.getCashNeeded().compareTo(new BigDecimal(0)) == 1) {
                cash_on_cash = ((home.getCashFlow().multiply(new BigDecimal(12))).divide(home.getCashNeeded(), MathContext.DECIMAL128).multiply(new BigDecimal(100))).setScale(1, RoundingMode.HALF_UP);
            }
            home.setCashOnCash(cash_on_cash);

            BigDecimal rent_to_value = new BigDecimal(0);
            if (home.getHomePrice().compareTo(new BigDecimal(0)) == 1) {
                rent_to_value = ((home.getMonthlyRent()).divide(home.getHomePrice(), MathContext.DECIMAL128).multiply(new BigDecimal(100))).setScale(1, RoundingMode.HALF_UP);
            }
            home.setRentToValue(rent_to_value);

            BigDecimal gross_rent_multiplier = new BigDecimal(0);
            if ((home.getMonthlyRent().multiply(new BigDecimal(12))).compareTo(new BigDecimal(0)) == 1) {
                gross_rent_multiplier = ((home.getHomePrice()).divide((home.getMonthlyRent().multiply(new BigDecimal(12))), MathContext.DECIMAL128)).setScale(1, RoundingMode.HALF_UP);
            }
            home.setGrossRentMultiplier(gross_rent_multiplier);

            BigDecimal debt_coverage_ratio = new BigDecimal(0);
            if ((home.getMonthlyPayment().multiply(new BigDecimal(12))).compareTo(new BigDecimal(0)) == 1) {
                debt_coverage_ratio = (home.getNetOperatingIncome().multiply(new BigDecimal(12))).divide((home.getMonthlyPayment().multiply(new BigDecimal(12))), MathContext.DECIMAL128).setScale(1, RoundingMode.HALF_UP);
            }

            home.setDebtCoverageRatio(debt_coverage_ratio);

            dealCalculation.setAddress(home.getAddress());
            dealCalculation.setAfterrepairprice(home.getAfterRepairPrice());
            dealCalculation.setAfterrepairvalue(home.getAfterRepairValue());
            dealCalculation.setAreasqft(home.getAreaSqft());
            dealCalculation.setBaths(home.getBaths());
            dealCalculation.setBeds(home.getBeds());
            dealCalculation.setCashflow(home.getCashFlow());
            dealCalculation.setCashneeded(home.getCashNeeded());
            dealCalculation.setCashoncash(home.getCashOnCash());
            if (dealCalculation.getId() != null && dealCalculation.getId() > 0) {
                isNew = false;
                dealCalculation.setModifiedby(Long.parseLong(sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()).toString()));
                dealCalculation.setModifieddate(new Date());
            } else {
                isNew = true;
                dealCalculation.setCreatedby(Long.parseLong(sessionUtils.getSessionValue(request, StatusEnums.USERID.toString()).toString()));
                dealCalculation.setCreateddate(new Date());

            }
            dealCalculation.setCreditscore(home.getCreditScore());
            dealCalculation.setCurrentprice(home.getCurrentPrice());
            dealCalculation.setDebtcoverageratio(home.getDebtCoverageRatio());
            dealCalculation.setDownpayment(home.getDownPayment());
            dealCalculation.setDownpaymentpercentage(home.getDownPaymentPercentage());
            dealCalculation.setGrossrentmultiplier(home.getGrossRentMultiplier());
            dealCalculation.setHoadues(home.getHoaDues());
            dealCalculation.setHomeinsurance(home.getHomeInsurance());
            dealCalculation.setHomeinsurancepercentage(home.getHomeInsurancePercentage());
            dealCalculation.setHomeprice(home.getHomePrice());
            dealCalculation.setInterestamount(home.getInterestAmount());
            dealCalculation.setInterestrate(home.getInterestRate());
            dealCalculation.setLoantype(home.getLoanType());
            dealCalculation.setMaintainance(home.getMaintainance());
            dealCalculation.setMaintainancepercentage(home.getMaintainancePercentage());
            dealCalculation.setMarketvaluecaprate(home.getMarketValueCapRate());
            dealCalculation.setMonthlycapreserv(home.getMonthlyCapReserv());
            dealCalculation.setMonthlycapreservpercentage(home.getMonthlyCapReservPercentage());
            dealCalculation.setMonthlypayment(home.getMonthlyPayment());
            dealCalculation.setMonthlyrent(home.getMonthlyRent());
            dealCalculation.setMortageinsurance(home.getMortageInsurance());
            dealCalculation.setNetoperatingincome(home.getNetOperatingIncome());
            dealCalculation.setNoofpayments(home.getNoOfPayments());
            dealCalculation.setOperatingexpenses(home.getOperatingExpenses());
            dealCalculation.setOperatingincome(home.getOperatingIncome());
            dealCalculation.setOthermonthlycost(home.getOtherMonthlyCost());
            dealCalculation.setPrice(home.getPrice());
            dealCalculation.setPrincipalamount(home.getPrincipalAmount());
            dealCalculation.setPropertyid(home.getPropertyID());
            dealCalculation.setPropertymanagement(home.getPropertyManagement());
            dealCalculation.setPropertytax(home.getPropertyTax());
            dealCalculation.setPropertytaxpercentage(home.getPropertyTaxPercentage());
            dealCalculation.setPurchaseprice(home.getPurchasePrice());
            dealCalculation.setPurchasepricecaprate(home.getPurchasePriceCapRate());
            dealCalculation.setPurchasepricepercentage(home.getPurchasePricePercentage());
            dealCalculation.setRehabcost(home.getRehabCost());
            dealCalculation.setRenttovalue(home.getRentToValue());
            dealCalculation.setStatus(StatusEnums.ACTIVE.toString());
            dealCalculation.setVacancyrate(home.getVacancyrate());

            dealCalculationService.save(dealCalculation);

            if (dealCalculation.getId() > 0) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("IsSuccess", Boolean.TRUE);
                jsonObject.addProperty("AuthenticationError", Boolean.FALSE);
                if (isNew) {
                    jsonObject.addProperty("Message", "Property details has been saved successfully");
                } else {
                    jsonObject.addProperty("Message", "Property details has been updated successfully");
                }
                return ResponseEntity.ok(jsonObject);
            } else {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("IsSuccess", Boolean.FALSE);
                jsonObject.addProperty("AuthenticationError", Boolean.FALSE);
                jsonObject.addProperty("Message", "Unable to save property details");
                return ResponseEntity.ok(jsonObject);
            }
        } catch (Exception ex) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IsSuccess", Boolean.FALSE);
            jsonObject.addProperty("AuthenticationError", Boolean.FALSE);
            jsonObject.addProperty("Message", ex.getMessage());
            return ResponseEntity.ok(jsonObject);
        }

    }

    // This method is used to get the property list by the given parameters
    public HomeViewModel SearchProperty(long limit, HomeViewModel model, HttpServletRequest httpServletRequest) throws IOException {

        try {
            HttpClient client = HttpClientBuilder.create().build();

            String query = StatusEnums.SIMPLYRETS_BASEAPI.toString() + "/properties?limit=" + limit + "&include=association&include=agreement&include=garageSpaces&include=maintenanceExpense&include=parking&include=pool&include=rooms&include=taxAnnualAmount&include=taxYear&count=true";

            if (model.getbFilter() != null && model.getbFilter()) {
                if (model.getSearch() != null) {
                    query += "&q=" + model.getSearch().replaceAll("\\s", "");
                }

                //============================================

                // Filter has been applied any one value from this is selected e.g. All , Sale , Rent, Sold
                if (model.getPropertyStatus() != null) {
                    if (model.getPropertyStatus().equalsIgnoreCase("All")) {
                        query += "&status=Active&status=Pending&status=Closed&";
                        if (model.getPropertySubType() != null) {
                            if (model.getPropertySubType().contains("singlefamilyresidence")) {
                                query += "&type=residential";
                            }
                            if (model.getPropertySubType().contains("townhouse")) {
                                query += "&subtype=townhouse";
                            }
                            if (model.getPropertySubType().contains("condominium")) {
                                query += "&type=condominium&subtype=condominium";
                            }
                            if (model.getPropertySubType().contains("other")) {
                                query += "subtype=apartment&" +
                                        "subtype=boatslip&" +
                                        "subtype=singlefamilyresidence&" +
                                        "subtype=deededparking&" +
                                        "subtype=cabin&" +
                                        "subtype=condominium&" +
                                        "subtype=duplex&" +
                                        "subtype=manufacturedhome&" +
                                        "subtype=ownyourown&" +
                                        "subtype=quadruplex&" +
                                        "subtype=stockcooperative&" +
                                        "subtype=townhouse&" +
                                        "subtype=timeshare&" +
                                        "subtype=triplex&" +
                                        "subtype=manufacturedonland&" +
                                        "idx=null&count=true";
                            }
                        }
                    } else if (model.getPropertyStatus().equalsIgnoreCase("Sale")) {
                        if (model.getPropertySubType() != null) {
                            if (model.getPropertySubType().contains("singlefamilyresidence")) {
                                query += "&type=residential";
                            }
                            if (model.getPropertySubType().contains("townhouse")) {
                                query += "&subtype=townhouse";
                            }
                            if (model.getPropertySubType().contains("condominium")) {
                                query += "&type=condominium&subtype=condominium";
                            }
                            if (model.getPropertySubType().contains("other")) {
                                query += "subtype=apartment&" +
                                        "subtype=boatslip&" +
                                        "subtype=singlefamilyresidence&" +
                                        "subtype=deededparking&" +
                                        "subtype=cabin&" +
                                        "subtype=condominium&" +
                                        "subtype=duplex&" +
                                        "subtype=manufacturedhome&" +
                                        "subtype=ownyourown&" +
                                        "subtype=quadruplex&" +
                                        "subtype=stockcooperative&" +
                                        "subtype=townhouse&" +
                                        "subtype=timeshare&" +
                                        "subtype=triplex&" +
                                        "subtype=manufacturedonland&" +
                                        "idx=null&count=true";
                            }
                        }


                    } else if (model.getPropertyStatus().equalsIgnoreCase("Rental")) {
                        query += "&type=rental";
                        if (model.getPropertySubType() != null) {
                            if (model.getPropertySubType().contains("singlefamilyresidence")) {
                                query += "&type=residential&subtype=singlefamilyresidence";
                            }
                            if (model.getPropertySubType().contains("townhouse")) {
                                query += "&subtype=townhouse";
                            }
                            if (model.getPropertySubType().contains("condominium")) {
                                query += "&type=condominium&subtype=condominium";
                            }
                            if (model.getPropertySubType().contains("other")) {
                                query += "&subtype=apartment&" +
                                        "subtype=boatslip&" +
                                        "subtype=singlefamilyresidence&" +
                                        "subtype=deededparking&" +
                                        "subtype=cabin&" +
                                        "subtype=condominium&" +
                                        "subtype=duplex&" +
                                        "subtype=manufacturedhome&" +
                                        "subtype=ownyourown&" +
                                        "subtype=quadruplex&" +
                                        "subtype=stockcooperative&" +
                                        "subtype=townhouse&" +
                                        "subtype=timeshare&" +
                                        "subtype=triplex&" +
                                        "subtype=manufacturedonland&" +
                                        "idx=null&count=true";
                            }
                        }
                    } else if (model.getPropertyStatus().equalsIgnoreCase("Closed")) {
                        query += "&status=Closed";
                        if (model.getPropertySubType() != null) {
                            if (model.getPropertySubType().contains("singlefamilyresidence")) {
                                query += "&type=residential";
                            }
                            if (model.getPropertySubType().contains("townhouse")) {
                                query += "&subtype=townhouse";
                            }
                            if (model.getPropertySubType().contains("condominium")) {
                                query += "&type=condominium&subtype=condominium";
                            }
                            if (model.getPropertySubType().contains("other")) {
                                query += "subtype=apartment&" +
                                        "subtype=boatslip&" +
                                        "subtype=singlefamilyresidence&" +
                                        "subtype=deededparking&" +
                                        "subtype=cabin&" +
                                        "subtype=condominium&" +
                                        "subtype=duplex&" +
                                        "subtype=manufacturedhome&" +
                                        "subtype=ownyourown&" +
                                        "subtype=quadruplex&" +
                                        "subtype=stockcooperative&" +
                                        "subtype=townhouse&" +
                                        "subtype=timeshare&" +
                                        "subtype=triplex&" +
                                        "subtype=manufacturedonland&" +
                                        "idx=null&count=true";
                            }
                        }
                    }
                } else {
                    query += "&status=Active";
                }

                if (model.getMinLotSize() != null) {
                    query += "&minacres=" + model.getMinLotSize();
                }
                if (model.getMaxLotSize() != null) {
                    query += "&maxacres=" + model.getMaxLotSize();
                }
                if (model.getMinSqft() != null) {
                    query += "&minarea=" + model.getMinSqft();
                }
                if (model.getMaxSqft() != null) {
                    query += "&maxarea=" + model.getMaxSqft();
                }
                if (model.getMinYear() != null) {
                    query += "&minyear=" + model.getMinYear();
                }
                if (model.getMaxYear() != null) {
                    query += "&maxyear=" + model.getMaxYear();
                }
                if (model.getMinBaths() != null) {
                    query += "&minbaths=" + model.getMinBaths();
                }

                if (model.getMaxBaths() != null) {
                    query += "&maxbaths=" + model.getMaxBaths();
                }
                if (model.getMinBeds() != null) {
                    query += "&minbeds=" + model.getMinBeds();
                }
                if (model.getMaxBeds() != null) {
                    query += "&maxbeds=" + model.getMaxBeds();
                }
                if (model.getMinPrice() != null) {
                    query += "&minprice=" + model.getMinPrice();
                }
                if (model.getMaxPrice() != null) {
                    query += "&maxprice=" + model.getMaxPrice();
                }
                if (model.getZipCode() != null) {
                    query += "&postalCodes=" + model.getZipCode();
                }
            }


            System.out.println("Query :" + query);

            //HttpOptions request = new HttpOptions(query);
            HttpGet request = new HttpGet(query);

            MaRestapiKeys maRestapiKeys = apiKeyService.GetApiKey(StatusEnums.ACTIVE.toString());
            String strcredentials = "";
            if (maRestapiKeys != null) {
                strcredentials = maRestapiKeys.getApikey() + ":" + maRestapiKeys.getApisecret();
            } else {
                strcredentials = "simplyrets:simplyrets";
            }

            byte[] credentials = strcredentials.getBytes();

            // add request header
            request.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials));
            request.addHeader("Accept", "application/json");

            HttpResponse response = client.execute(request);

            //Header[] fff=response.getAllHeaders();
            if (response.containsHeader("X-Total-Count") && response.getFirstHeader("X-Total-Count").getValue() != null) {
                model.setTotalProperties(Integer.parseInt(response.getFirstHeader("X-Total-Count").getValue()));
            }

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            List<RestProperty> property = new ArrayList<>();

            Type listType = new TypeToken<ArrayList<RestProperty>>() {
            }.getType();
            property = new Gson().fromJson(result.toString(), listType);


            property.forEach(m
                    -> {
                DecimalFormat decimalFormat = new DecimalFormat("##.00");
                NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));

                m.setFormattedPrice("$" + nf.format(m.getListPrice()));
                if (m.getProperty().getArea() > 0) {
                    // this is used for get the price of 1 sqft
                    BigDecimal sqftprice = (new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128)).setScale(2, RoundingMode.HALF_UP);
                    m.setFormattedSqftPrice("$" + nf.format(sqftprice));
                }

            });

            // filter property
            if (model.getPropertyStatus().equalsIgnoreCase("rental")) {
                property = property.stream()
                        .filter(p -> p.getProperty().getType().equalsIgnoreCase("rnt"))
                        .collect(Collectors.toList());
            } else if (model.getPropertyStatus().equalsIgnoreCase("Sale")) {
                property = property.stream()
                        .filter(p -> !p.getProperty().getType().equalsIgnoreCase("rnt"))
                        .collect(Collectors.toList());
            }

            model.setList(property);

            // Gson gson = new Gson();

            // model.setJsonlist(gson.toJson(model.getList()));      ///(RestProperty) list to string
            // Gson gson2 = new Gson();
            List<Location> locationlist = new ArrayList<Location>();
            for (RestProperty item : model.getList()) {
                Location location = new Location();
                location.setLat(item.getGeo().getLat());
                location.setLng(item.getGeo().getLng());
                location.setContent(item.getGeo().getMarketArea());
                locationlist.add(location);
            }
            model.setLocations(locationlist);
            //  model.setLocationjson(gson2.toJson(locationlist));     ///(Location) list to string
            return model;
        } catch (Exception ex) {
            ex.printStackTrace();
            //  Gson gson = new Gson();
            //   model.setJsonlist(gson.toJson(new ArrayList<RestProperty>()));       ///(Restproperty) list to string
            model.setError("Error From Api: Unauthorized Access");
            return model;
        }
    }

    //This method is used to get the property details by propertyid
    public RestProperty GetPropertyDetailsByID(Long PropertyID) throws IOException {

        RestProperty property = new RestProperty();
        try {

            HttpClient client = HttpClientBuilder.create().build();

            String query = StatusEnums.SIMPLYRETS_BASEAPI.toString() + "/properties/" + PropertyID + "?include=association&include=agreement&include=garageSpaces&include=maintenanceExpense&include=parking&include=pool&include=rooms&include=taxAnnualAmount&include=taxYear";

            HttpGet apirequest = new HttpGet(query);

            MaRestapiKeys maRestapiKeys = apiKeyService.GetApiKey(StatusEnums.ACTIVE.toString());
            String strcredentials = "";
            if (maRestapiKeys != null) {
                strcredentials = maRestapiKeys.getApikey() + ":" + maRestapiKeys.getApisecret();
            } else {
                strcredentials = "simplyrets:simplyrets";
            }
            byte[] credentials = strcredentials.getBytes();

            // add request header
            apirequest.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials));
            apirequest.addHeader("Accept", "application/json");

            HttpResponse response = client.execute(apirequest);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            System.out.println("Response : " + result);


            Type listType = new TypeToken<RestProperty>() {
            }.getType();
            property = new Gson().fromJson(result.toString(), listType);

            return property;
        } catch (Exception ex) {
            property.setIsError(true);
            property.setError(ex.getMessage());
            return property;
        }
    }

    //This method is used to get the properties by zipcode 
    //used to get the average monthly rent
    //used to get the deal factor
    // this method calculate average monthly rent per 1 sqft
    // this method calculate average price per 1 sqft
    // keep in mind for deal factor calculation please pass status 'Closed' righ now it is active
//    public List<RestProperty> SearchPropertyByZipCode(int PropertyID, String ZipCode, Double Lat, Double Lng, String Type, String SubType, int Area, int Year_Built, int Beds, HttpServletRequest httpServletRequest, String status) throws IOException {
//
//        List<RestProperty> filteredproperty = new ArrayList<>();
//        try {
//
//            BigDecimal userPreferenceDistance = new BigDecimal(0.5);
//            Long areaSqft = 250L, YearBuilt = 0L, BedRooms = 0L;
//            int MinArea = 0, MaxArea = 0, MinYearBuilt = 0, MaxYearBuilt = 0, MinBeds = 0, MaxBeds = 0;
//
//            if (sessionUtils.getSessionValue(httpServletRequest, StatusEnums.USERID.toString()) != null) {
//                MaUserPreferences maUserPreferences = preferencesService.Select_MA_User_Preferences_By_UserID(Long.parseLong(sessionUtils.getSessionValue(httpServletRequest, StatusEnums.USERID.toString()).toString()), StatusEnums.ACTIVE.toString());
//                if (maUserPreferences != null) {
//                    userPreferenceDistance = maUserPreferences.getSearchradius() == null ? new BigDecimal(0.5) : maUserPreferences.getSearchradius();
//                    areaSqft = maUserPreferences.getAreasqft() == null ? 250L : maUserPreferences.getAreasqft();
//                    YearBuilt = maUserPreferences.getYearbuilt() == null ? 0L : maUserPreferences.getYearbuilt();
//                    BedRooms = maUserPreferences.getBedroom() == null ? 0L : maUserPreferences.getBedroom();
//                }
//            }
//
//            HttpClient client = HttpClientBuilder.create().build();
//
//            String query = StatusEnums.SIMPLYRETS_BASEAPI.toString() + "/properties?limit=500&count=true";
//
//            query += "&status=" + status;
//
//            if (ZipCode != null && !"".equals(ZipCode)) {
//                query += "&postalCodes=" + ZipCode;
//            }
//            if (Type != null && !"".equals(Type)) {
//                if (Type.equalsIgnoreCase("RES")) {
//                    query += "&type=residential";
//                } else if (Type.equalsIgnoreCase("RNT")) {
//                    query += "&type=rental";
//                } else if (Type.equalsIgnoreCase("MLF")) {
//                    query += "&type=multifamily";
//                } else if (Type.equalsIgnoreCase("CND")) {
//                    query += "&type=condominium";
//                } else if (Type.equalsIgnoreCase("CRE")) {
//                    query += "&type=commercial";
//                } else if (Type.equalsIgnoreCase("LND")) {
//                    query += "&type=land";
//                } else if (Type.equalsIgnoreCase("FRM")) {
//                    query += "&type=farm";
//                }
//
//            }
//            if (SubType != null && !"".equals(SubType)) {
//                query += "&subtype=" + SubType.toLowerCase();
//            }
//            if (Area > 0) {
//                MinArea = Area - areaSqft.intValue();
//                MaxArea = Area + areaSqft.intValue();
//                query += "&minarea=" + MinArea;
//                query += "&maxarea=" + MaxArea;
//            }
//            if (YearBuilt > 0) {
//                MinYearBuilt = Year_Built - YearBuilt.intValue();
//                MaxYearBuilt = Year_Built + YearBuilt.intValue();
//                query += "&minyear=" + MinYearBuilt;
//                query += "&maxyear=" + MaxYearBuilt;
//            }
//            if (BedRooms > 0) {
//                MinBeds = Beds - BedRooms.intValue();
//                MaxBeds = Beds + BedRooms.intValue();
//                query += "&minbeds=" + MinBeds;
//                query += "&maxbeds=" + MaxBeds;
//            }
//            HttpGet request = new HttpGet(query);
//
//            MaRestapiKeys maRestapiKeys = apiKeyService.GetApiKey(StatusEnums.ACTIVE.toString());
//            String strcredentials = "";
//            if (maRestapiKeys != null) {
//                strcredentials = maRestapiKeys.getApikey() + ":" + maRestapiKeys.getApisecret();
//            } else {
//                strcredentials = "simplyrets:simplyrets";
//            }
//
//            byte[] credentials = strcredentials.getBytes();
//
//            // add request header
//            request.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials));
//            request.addHeader("Accept", "application/json");
//
//            HttpResponse response = client.execute(request);
//
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            StringBuilder result = new StringBuilder();
//            System.out.println("Result : " + result);
//            String line = "";
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//
//            List<RestProperty> property = new ArrayList<>();
//
//            Type listType = new TypeToken<ArrayList<RestProperty>>() {
//            }.getType();
//            property = new Gson().fromJson(result.toString(), listType);
//
//            property.forEach(m
//                    -> {
//                DecimalFormat decimalFormat = new DecimalFormat("##.00");
//                NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
//                m.setFormattedPrice("$" + nf.format(m.getListPrice()));
//                if (m.getProperty().getArea() > 0) {
//                    BigDecimal sqftprice = (new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128)).setScale(2, RoundingMode.HALF_UP);
//                    m.setFormattedSqftPrice("$" + nf.format(sqftprice));
//                    //m.setFormattedSqftPrice("$" + nf.format(Double.parseDouble(decimalFormat.format(Math.round(m.getListPrice() / m.getProperty().getArea())))));
//                }
//                if (m.getGeo() != null && m.getGeo().getLat() != null && m.getGeo().getLng() != null) {
//                    m.setDistance(EncryptionMethods.GetDistanceBetweenTwoLatLong(m.getGeo().getLat(), m.getGeo().getLng(), Lat, Lng, ""));
//                } else {
//                    m.setDistance(new BigDecimal(0));
//                }
//                m.setFormattedRentPrice("$" + nf.format(Double.parseDouble(decimalFormat.format(Math.round(m.getListPrice() * 0.01)))));
//            });
//
//            final BigDecimal distance = userPreferenceDistance;
//            filteredproperty = property.stream()
//                            .filter(m -> m.getDistance()
//                            .compareTo(distance) <= 0 && m.getMlsId() != PropertyID)
//                            .collect(Collectors.toList());
//
//            if (filteredproperty.size() > 0) {
//                if ("Closed".equals(status)) {
//                    filteredproperty.forEach(m -> {
//                        if (m.getProperty().getArea() > 0 && m.getSales() != null) {
//                            m.setClosePricePerArea(new BigDecimal(m.getSales().getClosePrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
//                        }
//                    });
//
//                } else {
//                    filteredproperty.forEach(m -> {
//                        if (m.getProperty().getArea() > 0) {
//                            m.setListPricePerArea(new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
//                        }
//                    });
//
//                }
//            }
//
//        } catch (Exception ex) {
//
//        }
//        return filteredproperty;
//    }


    public List<RestProperty> SearchPropertyByZipCode(int PropertyID, String ZipCode, Double Lat, Double Lng, String Type, String SubType, int Area, int Year_Built, int Beds, HttpServletRequest httpServletRequest, String status) throws IOException {

        List<RestProperty> filteredproperty = new ArrayList<>();
        try {

            BigDecimal userPreferenceDistance = new BigDecimal(0.5);
            Long areaSqft = 250L, YearBuilt = 0L, BedRooms = 0L;
            int MinArea = 0, MaxArea = 0, MinYearBuilt = 0, MaxYearBuilt = 0, MinBeds = 0, MaxBeds = 0;

            if (sessionUtils.getSessionValue(httpServletRequest, StatusEnums.USERID.toString()) != null) {
                MaUserPreferences maUserPreferences = preferencesService.Select_MA_User_Preferences_By_UserID(Long.parseLong(sessionUtils.getSessionValue(httpServletRequest, StatusEnums.USERID.toString()).toString()), StatusEnums.ACTIVE.toString());
                if (maUserPreferences != null) {
                    userPreferenceDistance = maUserPreferences.getSearchradius() == null ? new BigDecimal(0.5) : maUserPreferences.getSearchradius();
                    areaSqft = maUserPreferences.getAreasqft() == null ? 250L : maUserPreferences.getAreasqft();
                    YearBuilt = maUserPreferences.getYearbuilt() == null ? 0L : maUserPreferences.getYearbuilt();
                    BedRooms = maUserPreferences.getBedroom() == null ? 0L : maUserPreferences.getBedroom();
                }
            }

            HttpClient client = HttpClientBuilder.create().build();

            String query = StatusEnums.SIMPLYRETS_BASEAPI.toString() + "/properties?limit=500&count=true";

            query += "&status=" + status;

            if (ZipCode != null && !"".equals(ZipCode)) {
                query += "&postalCodes=" + ZipCode;
            }
            if (Type != null && !"".equals(Type)) {
                if (Type.equalsIgnoreCase("RES")) {
                    query += "&type=residential";
                } else if (Type.equalsIgnoreCase("RNT")) {
                    query += "&type=rental";
                } else if (Type.equalsIgnoreCase("MLF")) {
                    query += "&type=multifamily";
                } else if (Type.equalsIgnoreCase("CND")) {
                    query += "&type=condominium";
                } else if (Type.equalsIgnoreCase("CRE")) {
                    query += "&type=commercial";
                } else if (Type.equalsIgnoreCase("LND")) {
                    query += "&type=land";
                } else if (Type.equalsIgnoreCase("FRM")) {
                    query += "&type=farm";
                }

            }
            if (SubType != null && !"".equals(SubType)) {
                query += "&subtype=" + SubType.toLowerCase();
            }
            if (Area > 0) {
                MinArea = Area - areaSqft.intValue();
                MaxArea = Area + areaSqft.intValue();
                query += "&minarea=" + MinArea;
                query += "&maxarea=" + MaxArea;
            }
            if (YearBuilt > 0) {
                MinYearBuilt = Year_Built - YearBuilt.intValue();
                MaxYearBuilt = Year_Built + YearBuilt.intValue();
                query += "&minyear=" + MinYearBuilt;
                query += "&maxyear=" + MaxYearBuilt;
            }
            if (BedRooms > 0) {
                MinBeds = Beds - BedRooms.intValue();
                MaxBeds = Beds + BedRooms.intValue();
                query += "&minbeds=" + MinBeds;
                query += "&maxbeds=" + MaxBeds;
            }
            HttpGet request = new HttpGet(query);

            MaRestapiKeys maRestapiKeys = apiKeyService.GetApiKey(StatusEnums.ACTIVE.toString());
            String strcredentials = "";
            if (maRestapiKeys != null) {
                strcredentials = maRestapiKeys.getApikey() + ":" + maRestapiKeys.getApisecret();
            } else {
                strcredentials = "simplyrets:simplyrets";
            }

            byte[] credentials = strcredentials.getBytes();

            // add request header
            request.addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString(credentials));
            request.addHeader("Accept", "application/json");

            HttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            List<RestProperty> property = new ArrayList<>();

            java.lang.reflect.Type listType = new TypeToken<ArrayList<RestProperty>>() {
            }.getType();
            property = new Gson().fromJson(result.toString(), listType);

            property.forEach(m
                    -> {
                DecimalFormat decimalFormat = new DecimalFormat("##.00");
                NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
                m.setFormattedPrice("$" + nf.format(m.getListPrice()));
                if (m.getProperty().getArea() > 0) {
                    BigDecimal sqftprice = (new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128)).setScale(2, RoundingMode.HALF_UP);
                    m.setFormattedSqftPrice("$" + nf.format(sqftprice));
                    //m.setFormattedSqftPrice("$" + nf.format(Double.parseDouble(decimalFormat.format(Math.round(m.getListPrice() / m.getProperty().getArea())))));
                }
                if (m.getGeo() != null && m.getGeo().getLat() != null && m.getGeo().getLng() != null) {
                    m.setDistance(EncryptionMethods.GetDistanceBetweenTwoLatLong(m.getGeo().getLat(), m.getGeo().getLng(), Lat, Lng, ""));
                } else {
                    m.setDistance(new BigDecimal(0));
                }
                m.setFormattedRentPrice("$" + nf.format(Double.parseDouble(decimalFormat.format(Math.round(m.getListPrice() * 0.01)))));
            });
            final BigDecimal distance = userPreferenceDistance;
            filteredproperty = property.stream().filter(m -> m.getDistance().compareTo(distance) <= 0 && m.getMlsId() != PropertyID).collect(Collectors.toList());

            if (filteredproperty.size() > 0) {
                if ("Closed".equals(status)) {
                    filteredproperty.forEach(m -> {


                        if (m.getProperty().getArea() > 0) {
                            if (m.getSales() != null && m.getSales().getClosePrice() > 0) {
                                m.setClosePricePerArea(new BigDecimal(m.getSales().getClosePrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
                            } else {
                                m.setClosePricePerArea(new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
                            }


                        }


                    });

                } else {
                    filteredproperty.forEach(m -> {
                        if (m.getProperty().getArea() > 0) {
                            m.setListPricePerArea(new BigDecimal(m.getListPrice()).divide(new BigDecimal(m.getProperty().getArea()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
                        }
                    });

                }
            }

        } catch (Exception ex) {

        }
        return filteredproperty;
    }

    // this method will calculate the average of list
    public BigDecimal GetAverageOfPricePerArea(List<RestProperty> restPropertys, String status) {
        BigDecimal avgPrice = new BigDecimal(BigInteger.ZERO);
        try {
            if (restPropertys.size() > 0) {
                if ("Closed".equals(status)) {

                    BigDecimal Sum = restPropertys.stream()
                            .map(RestProperty::getClosePricePerArea)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    avgPrice = Sum.divide(new BigDecimal(restPropertys.size()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
                    //avgPrice = new BigDecimal(restPropertys.stream().mapToDouble(i -> BigDecimal::i.getClosePricePerArea()).average().getAsDouble());
                } else {
                    BigDecimal Sum = restPropertys.stream()
                            .map(RestProperty::getListPricePerArea)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    avgPrice = Sum.divide(new BigDecimal(restPropertys.size()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
                    //avgPrice = new BigDecimal(restPropertys.stream().mapToDouble(i -> i.getListPricePerArea()).average().getAsDouble());
                }
            }
        } catch (Exception ex) {

        }
        return avgPrice;
    }

    //This method will get the crime list for the specific lat and lng means for specific property
    public CrimeDetails GetCrimeListByLatAndLong(Double Lat, Double Lng, String StartDate, String EndDate, HttpServletRequest httpServletRequest) {
        CrimeDetails list = new CrimeDetails();
        StringBuilder result = new StringBuilder();
        try {

            BigDecimal Distance = new BigDecimal(10);

            if (sessionUtils.getSessionValue(httpServletRequest, StatusEnums.USERID.toString()) != null) {
                MaUserPreferences maUserPreferences = preferencesService.Select_MA_User_Preferences_By_UserID(Long.parseLong(sessionUtils.getSessionValue(httpServletRequest, StatusEnums.USERID.toString()).toString()), StatusEnums.ACTIVE.toString());
                if (maUserPreferences != null) {
                    Distance = maUserPreferences.getSearchradius() == null ? new BigDecimal(1) : maUserPreferences.getSearchradius();
                }
            }

            HttpClient client = HttpClientBuilder.create().build();

            String query = StatusEnums.CRIME_BASEAPI.toString() + "?lat=" + Lat + "&lon=" + Lng + "&distance=" + Distance + "mi&datetime_ini=" + StartDate + "&datetime_end=" + EndDate + "&page=1";

            HttpGet request = new HttpGet(query);

            request.addHeader("x-api-key", StatusEnums.CRIME_API_KEY.toString());
            request.addHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            Type listType = new TypeToken<CrimeDetails>() {
            }.getType();
            list = new Gson().fromJson(result.toString(), listType);

        } catch (Exception ex) {
            list.setError(ex.getMessage());
        }
        return list;
    }

    @ExceptionHandler(UnAthorizedUserException.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("redirect:/Login");
        return model;
    }

    @ExceptionHandler(UnAthorizedSiteAccessException.class)
    public ModelAndView handleSiteException(Exception ex) {
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }
}
