/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Youssef
 */
public class Admin {
    
    private String adminName;
    private String adminPassword;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void addLibrarian(Librarian librarian)
    {
        Librarian.addInLibrarians(librarian);
    }
    public void viewLibrarians(javax.swing.JTable jTable1){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object rowData[] = new Object[7];
        for (int i = 0; i < Librarian.getLibrariansCount(); i++)
        {
            rowData[0] = Librarian.librarians[i].getLibrarianId();
            rowData[1] = Librarian.librarians[i].getLibrarianName();
            rowData[2] = Librarian.librarians[i].getLibrarianPassword();
            rowData[3] = Librarian.librarians[i].getLibrarianEmail();
            rowData[4] = Librarian.librarians[i].getLibrarianAddress();
            rowData[5] = Librarian.librarians[i].getLibrarianCity();
            rowData[6] = Librarian.librarians[i].getLibrarianNumber();
            model.addRow(rowData);
        }
    }
    
    public boolean deleteLibrarian(int librarianId){
        int deletedIndex = 0;
        boolean found = false;
        for (int i = 0; i < Librarian.getLibrariansCount(); i++)
        {
            if (Librarian.librarians[i].getLibrarianId() == librarianId)
            {
                found = true;
                deletedIndex = i;
            }
        }
        if (found)
        {
         
            for (int i = deletedIndex; i < Librarian.getLibrariansCount() - 1; i++)
            {
                Librarian.librarians[i] = Librarian.librarians[i+1];

            }
            Librarian.decrementLibrarianCount();
                
        }
        return found;
}
}
