package br.com.project.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.project.schedule.Gender;

@ManagedBean
public class GenderBean {
  public SelectItem[] getGenderValues() {
    SelectItem[] items = new SelectItem[Gender.values().length];
    int i = 0;
    for(Gender g: Gender.values()) {
      items[i++] = new SelectItem(g, g.getGender());
    }
    return items;
  }
}
