/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.List;

/**
 *
 * @author ABDELLAH DIDI
 */
public interface  idao <t> {
        public  void add(t  a);
        public void delete(t a );
        public void update(t a  );
        public boolean signup(t a );
        public void show(t  a );
        public List<t> lister();
}
