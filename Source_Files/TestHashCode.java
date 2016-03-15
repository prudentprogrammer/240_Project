public int hashCode() {
return getFirstName().hashCode() 
+
getLastName().hashCode() 
+
getPhoneHome().hashCode() 
+
getCellPhone().hashCode();
}
