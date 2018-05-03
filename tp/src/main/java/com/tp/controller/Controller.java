package com.tp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.model.Informacion;
import com.tp.repositorioJPA.RepositorioJPA;

import eu.bitwalker.useragentutils.UserAgent;

@RestController

public class Controller {
    int moz, chro, exp, edge, safari, oper, otro;
    int win, linux, macOS, otroSO;
    int firefoxWindows, firefoxLinux, firefoxMacos, chroWindows, chroLinux, chroMacos, expWindows, expLinux, expMacos,
	    edgeWindows, edgeLinux, edgeMacos, safariWindows, safariLinux, safariMacos, operWindows, otroComb,
	    operMacos, operLinux;

    @Autowired
    private RepositorioJPA all;

    @RequestMapping(value = "/")
    public String hello2(@RequestHeader(value = "User-Agent") String userAgent) {

	UserAgent userAgent1 = UserAgent.parseUserAgentString(userAgent);

	String convertedToString = String.valueOf(userAgent1);

	String string = convertedToString;
	String[] parts = string.split("-");
	String part1 = parts[0]; // browser
	String part2 = parts[1]; // systemaOp

	Informacion info = new Informacion(part1, part2);

	all.save(info);

	return " El browser mas utilizado fue " + cantidadBrowser(info).toString()
		+ " <br> El sistema operativo mas utilizado fue " + cantidadSO(info).toString()
		+ " <br> La combinacion mas utilizada fue " + cantidadSOyBrowser(info).toString();

    }

    public String cantidadBrowser(Informacion browser) {

	if (browser.getBrowser().contains("FIREFOX")) {
	    moz++;
	} else if (browser.getBrowser().contains("CHROME")) {
	    chro++;
	} else if (browser.getBrowser().contains("IE")) {
	    exp++;
	} else if (browser.getBrowser().contains("EDGE")) {
	    edge++;
	} else if (browser.getBrowser().contains("SAFARI")) {
	    safari++;
	} else if (browser.getBrowser().contains("OPERA")) {
	    oper++;
	} else {
	    otro++;
	}

	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("Firefox", moz);
	map.put("Chrome", chro);
	map.put("Internet Explorer", exp);
	map.put("Edge", edge);
	map.put("Safari", safari);
	map.put("Opera", oper);
	map.put("Otro", otro);

	Set<String> keySet = new HashSet<String>();
	for (Entry<String, Integer> entry : map.entrySet()) {
	    if (entry.getValue() == Collections.max(map.values())) {
		keySet.add(entry.getKey());
	    }
	}
	return keySet.toString() + " Utilizado " + Collections.max(map.values()).toString() + " veces";
    }

    public String cantidadSO(Informacion SO) {

	if (SO.getOp().contains("WINDOWS")) {
	    win++;
	} else if (SO.getOp().contains("LINUX")) {
	    linux++;
	} else if (SO.getOp().contains("MACOS")) {
	    macOS++;
	} else {
	    otroSO++;
	}

	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("Windows", win);
	map.put("Linux", linux);
	map.put("Mac Os", macOS);
	map.put("Otro", otroSO);

	Set<String> keySet = new HashSet<String>();
	for (Entry<String, Integer> entry : map.entrySet()) {
	    if (entry.getValue() == Collections.max(map.values())) {
		keySet.add(entry.getKey());
	    }
	}
	return keySet.toString() + " Utilizado " + Collections.max(map.values()).toString() + " veces";
    }

    public String cantidadSOyBrowser(Informacion info) {

	if (info.getBrowser().contains("FIREFOX") && info.getOp().contains("WINDOWS")) {
	    firefoxWindows++;
	} else if (info.getBrowser().contains("FIREFOX") && info.getOp().contains("LINUX")) {
	    firefoxLinux++;
	} else if (info.getBrowser().contains("FIREFOX") && info.getOp().contains("MACOS")) {
	    firefoxMacos++;
	} else if (info.getBrowser().contains("CHROME") && info.getOp().contains("WINDOWS")) {
	    chroWindows++;
	} else if (info.getBrowser().contains("CHROME") && info.getOp().contains("LINUX")) {
	    chroLinux++;
	} else if (info.getBrowser().contains("CHROME") && info.getOp().contains("MACOS")) {
	    chroMacos++;
	} else if (info.getBrowser().contains("IE") && info.getOp().contains("WINDOWS")) {
	    expWindows++;
	} else if (info.getBrowser().contains("IE") && info.getOp().contains("LINUX")) {
	    expLinux++;
	} else if (info.getBrowser().contains("IE") && info.getOp().contains("MACOS")) {
	    expMacos++;
	} else if (info.getBrowser().contains("EDGE") && info.getOp().contains("WINDOWS")) {
	    edgeWindows++;
	} else if (info.getBrowser().contains("EDGE") && info.getOp().contains("LINUX")) {
	    edgeLinux++;
	} else if (info.getBrowser().contains("EDGE") && info.getOp().contains("MACOS")) {
	    edgeMacos++;
	} else if (info.getBrowser().contains("SAFARI") && info.getOp().contains("WINDOWS")) {
	    safariWindows++;
	} else if (info.getBrowser().contains("SAFARI") && info.getOp().contains("LINUX")) {
	    safariLinux++;
	} else if (info.getBrowser().contains("SAFARI") && info.getOp().contains("MACOS")) {
	    safariMacos++;
	} else if (info.getBrowser().contains("OPERA") && info.getOp().contains("WINDOWS")) {
	    operWindows++;
	} else if (info.getBrowser().contains("OPERA") && info.getOp().contains("LINUX")) {
	    operLinux++;
	} else if (info.getBrowser().contains("OPERA") && info.getOp().contains("MACOS")) {
	    operMacos++;
	} else {
	    otroComb++;
	}

	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("Firefox y Windows", firefoxWindows);
	map.put("Firefox y Linux", firefoxLinux);
	map.put("Firefox y Mac Os", firefoxMacos);
	map.put("Chrome y Windows", chroWindows);
	map.put("Chrome y Linux", chroLinux);
	map.put("Chrome y MacOs", chroMacos);
	map.put("Internet Explorer y Windows", expWindows);
	map.put("Internet Explorer y Linux", expLinux);
	map.put("Internet Explorer y Mac Os", expMacos);
	map.put("Edge y Windows", edgeWindows);
	map.put("Edge y Linux", edgeLinux);
	map.put("Edge y Mac Os", edgeMacos);
	map.put("Safari y Windows", safariWindows);
	map.put("Safari y Linux", safariLinux);
	map.put("Safari y Mac Os", safariMacos);
	map.put("Opera y  Windows", operWindows);
	map.put("Opera y Windows", operLinux);
	map.put("Opera y Mac Os", operMacos);
	map.put("Otra combinacion", otroComb);

	Set<String> keySet = new HashSet<String>();
	for (Entry<String, Integer> entry : map.entrySet()) {
	    if (entry.getValue() == Collections.max(map.values())) {
		keySet.add(entry.getKey());
	    }
	}
	return keySet.toString() + " Utilizado " + Collections.max(map.values()).toString() + " veces";

    }

}