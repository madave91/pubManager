/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controllers;

import hu.elte.pubManager.repositories.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author madave91
 */
@RestController
@RequestMapping("foos")
public class BarController {
  @Autowired
  private BarRepository barRepository;
}
