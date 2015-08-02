package com.example.thewhites.myslhs;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventsList extends Activity {

    private static final int EDIT = 0, DELETE = 1;

    EditText nameTxt, phoneTxt, emailTxt, addressTxt;
    ImageView slhsLogo, sw;
    TextView subStatement, creatorTitle;
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;
    Button previous, next;
    Uri imageUri = Uri.parse("http://icons.iconarchive.com/icons/hopstarter/scrap/256/Briefcase-icon.png");
    DatabaseHandler dbHandler;
    int longClickedItemIndex;
    ArrayAdapter<Contact> contactAdapter;
    int image = R.drawable.breifcase, imageIc = R.drawable.breifcase;;
    String editedName = "", edited = "0", dbImage = "breifcase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
        nameTxt = (EditText) findViewById(R.id.txtName);
        phoneTxt = (EditText) findViewById(R.id.txtPhone);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        addressTxt = (EditText) findViewById(R.id.txtAddress);
        contactListView = (ListView) findViewById(R.id.listView);
        slhsLogo = (ImageView)findViewById(R.id.shorelandLogoEvents);
        subStatement = (TextView)findViewById(R.id.subStatementEvents);
        dbHandler = new DatabaseHandler(getApplicationContext());
        creatorTitle = (TextView) findViewById(R.id.lblCreatorTitle);
        previous = (Button)findViewById(R.id.previous);
        next = (Button)findViewById(R.id.next);
        sw = (ImageView)findViewById(R.id.imgViewContactImage);
        sw.setImageResource(image);

        slhsLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TeacherEdition.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        subStatement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Events.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "previous Image", Toast.LENGTH_LONG).show();
                if (image == R.drawable.breifcase) {
                    image = R.drawable.lock;
                }
                else if (image == R.drawable.lock) {
                    image = R.drawable.dude;
                }
                else if (image == R.drawable.dude) {
                    image = R.drawable.clock;
                }
                else if (image == R.drawable.clock) {
                    image = R.drawable.clipboard;
                }
                else if (image == R.drawable.clipboard) {
                    image = R.drawable.breifcase;
                }
                sw.setImageResource(image);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Next Image",Toast.LENGTH_LONG).show();
                if (image == R.drawable.breifcase) {
                    image = R.drawable.clipboard;
                }
                else if (image == R.drawable.clipboard) {
                    image = R.drawable.clock;
                }
                else if (image == R.drawable.clock) {
                    image = R.drawable.dude;
                }
                else if (image == R.drawable.dude) {
                    image = R.drawable.lock;
                }
                else if (image == R.drawable.lock) {
                    image = R.drawable.breifcase;
                }
                sw.setImageResource(image);
            }
        });

        registerForContextMenu(contactListView);

        contactListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                longClickedItemIndex = position;
                return false;
            }
        });

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("My Events");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("New Event");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (image == R.drawable.breifcase) {
                    dbImage = "breifcase";
                } else if (image == R.drawable.clipboard) {
                    dbImage = "clipboard";
                } else if (image == R.drawable.clock) {
                    dbImage = "clock";
                } else if (image == R.drawable.dude) {
                    dbImage = "dude";
                } else {
                    dbImage = "lock";
                }
                Contact contact = new Contact(dbHandler.getContactsCount(), String.valueOf(nameTxt.getText()), String.valueOf(phoneTxt.getText()), String.valueOf(emailTxt.getText()), String.valueOf(addressTxt.getText()), String.valueOf(dbImage));
                if (!contactExists(contact)) {
                    dbHandler.createContact(contact);
                    Contacts.add(contact);
                    contactAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText()) + " has been scheduled to your Events!", Toast.LENGTH_SHORT).show();
                    edited = "0";
                    clearEntry();
                    return;
                } if (Objects.equals(edited, "0")) {
                    dbHandler.createContact(contact);
                    Contacts.add(contact);
                    contactAdapter.notifyDataSetChanged();
                    edited = "0";
                    Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText()) + " has been scheduled to your Events!", Toast.LENGTH_SHORT).show();
                    clearEntry();
                    return;
                } if (Objects.equals(edited, "1")){
                    //delete old event
                    dbHandler.deleteContact(Contacts.get(longClickedItemIndex));
                    Contacts.remove(longClickedItemIndex);
                    contactAdapter.notifyDataSetChanged();
                    //create new event
                    dbHandler.createContact(contact);
                    Contacts.add(contact);
                    contactAdapter.notifyDataSetChanged();
                    edited = "0";
                    Toast.makeText(getApplicationContext(), String.valueOf(nameTxt.getText()) + "'s event name and information was switch successfully", Toast.LENGTH_SHORT).show();
                    clearEntry();
                }
            }
        });

        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                addBtn.setEnabled(String.valueOf(nameTxt.getText()).trim().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

            if (dbHandler.getContactsCount() != 0)
            Contacts.addAll(dbHandler.getAllContacts());

        populateList();
    }

    private void clearEntry() {
        nameTxt.setText("");
        phoneTxt.setText("");
        emailTxt.setText("");
        addressTxt.setText("");
        edited = "0";
        editedName = "";
        image = (R.drawable.breifcase);
        sw.setImageResource(image);
        creatorTitle.setText("Schedule an Event");
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        menu.setHeaderIcon(R.drawable.pencil_icon);
        menu.setHeaderTitle("Event Options");
        menu.add(Menu.NONE, EDIT, menu.NONE, "Edit Event");
        menu.add(Menu.NONE, DELETE, menu.NONE, "Delete Event");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case EDIT:
                // TODO: Implement editing a contact
                Contact currentContact = Contacts.get(longClickedItemIndex);
                nameTxt.setText(currentContact.getName());
                phoneTxt.setText(currentContact.getPhone());
                emailTxt.setText(currentContact.getEmail());
                addressTxt.setText(currentContact.getAddress());
                String summonImage = currentContact.getImage();
                if (Objects.equals(summonImage, "breifcase")) {
                    image = R.drawable.breifcase;
                } else if (Objects.equals(summonImage, "clipboard")) {
                    image = R.drawable.clipboard;
                } else if (Objects.equals(summonImage, "clock")) {
                    image = R.drawable.clock;
                } else if (Objects.equals(summonImage, "dude")) {
                    image = R.drawable.dude;
                } else if (Objects.equals(summonImage, "lock")) {
                    image = R.drawable.lock;
                }
                sw.setImageResource(image);
                creatorTitle.setText("Edit Event");
                edited = "1";
                editedName = (currentContact.getName());
                break;
            case DELETE:
                dbHandler.deleteContact(Contacts.get(longClickedItemIndex));
                Contacts.remove(longClickedItemIndex);
                contactAdapter.notifyDataSetChanged();
                break;
        }

        return super.onContextItemSelected(item);
    }

    private boolean contactExists(Contact contact) {
        String name = contact.getName();
        int contactCount = Contacts.size();

        for (int i = 0; i < contactCount; i++) {
            if (name.compareToIgnoreCase(Contacts.get(i).getName()) == 0)
                return true;
            if (editedName.compareToIgnoreCase(Contacts.get(i).getName()) == 0)
                return true;
        }
        return false;
    }

    private void populateList() {
        contactAdapter = new ContactListAdapter();
        contactListView.setAdapter(contactAdapter);
    }

    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter() {
            super (EventsList.this, R.layout.listview_item_contacts, Contacts);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item_contacts, parent, false);

            Contact currentContact = Contacts.get(position);

            TextView name = (TextView) view.findViewById(R.id.contactName);
            name.setText(currentContact.getName());
            TextView phone = (TextView) view.findViewById(R.id.phoneNumber);
            phone.setText(currentContact.getPhone());
            TextView email = (TextView) view.findViewById(R.id.emailAddress);
            email.setText(currentContact.getEmail());
            TextView address = (TextView) view.findViewById(R.id.cAddress);
            address.setText(currentContact.getAddress());

            String summonImage2 = currentContact.getImage();
            if (Objects.equals(summonImage2, "breifcase")) {
                imageIc = R.drawable.breifcase;
            } else if (Objects.equals(summonImage2, "clipboard")) {
                imageIc = R.drawable.clipboard;
            } else if (Objects.equals(summonImage2, "clock")) {
                imageIc = R.drawable.clock;
            } else if (Objects.equals(summonImage2, "dude")) {
                imageIc = R.drawable.dude;
            } else if (Objects.equals(summonImage2, "lock")) {
                imageIc = R.drawable.lock;
            }

            ImageView imageIcon = (ImageView) view.findViewById(R.id.ivContactImage);
            imageIcon.setImageResource(imageIc);
            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_teacher_edition, menu);
        return true;
    }

}