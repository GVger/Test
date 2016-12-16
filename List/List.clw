; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CSearchBox
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "list.h"
LastPage=0

ClassCount=7
Class1=CAddBox
Class2=CListApp
Class3=CListDlg
Class4=CModiBox
Class5=CModiDlg
Class6=CSearchBox

ResourceCount=5
Resource1=IDD_SEARCH
Resource2=IDD_LIST_DIALOG
Resource3=IDD_MODIBOX
Resource4=IDD_ADD
Class7=CAbout
Resource5=IDD_ABOUT

[CLS:CAddBox]
Type=0
BaseClass=CDialog
HeaderFile=AddBox.h
ImplementationFile=AddBox.cpp
LastObject=CAddBox

[CLS:CListApp]
Type=0
BaseClass=CWinApp
HeaderFile=List.h
ImplementationFile=List.cpp

[CLS:CListDlg]
Type=0
BaseClass=CDialog
HeaderFile=ListDlg.h
ImplementationFile=ListDlg.cpp
LastObject=CListDlg
Filter=D
VirtualFilter=dWC

[CLS:CModiBox]
Type=0
BaseClass=CDialog
HeaderFile=ModiBox.h
ImplementationFile=ModiBox.cpp

[CLS:CModiDlg]
Type=0
BaseClass=CDialog
HeaderFile=ModiDlg.h
ImplementationFile=ModiDlg.cpp

[CLS:CSearchBox]
Type=0
BaseClass=CDialog
HeaderFile=SearchBox.h
ImplementationFile=SearchBox.cpp
LastObject=IDC_NAME

[DLG:IDD_ADD]
Type=1
Class=CAddBox
ControlCount=8
Control1=IDC_STATIC,button,1342177287
Control2=IDC_STATIC,static,1342308352
Control3=IDC_STATIC,static,1342308352
Control4=IDC_NAME,edit,1350631552
Control5=IDC_PHONE,edit,1350631552
Control6=IDC_OK,button,1342242816
Control7=IDC_CANCEL,button,1342242816
Control8=IDC_STATIC,button,1342177287

[DLG:IDD_LIST_DIALOG]
Type=1
Class=CListDlg
ControlCount=10
Control1=IDC_OPEN,button,1342242816
Control2=IDC_SAVE,button,1342242816
Control3=IDC_ADD,button,1342242816
Control4=IDC_SEARCH,button,1342242816
Control5=IDC_CHANGE,button,1342242816
Control6=IDC_EXIT,button,1342242816
Control7=IDC_SEPARATOR,static,1073745927
Control8=IDC_STATIC,button,1342177287
Control9=IDC_CONTENT,listbox,1352728835
Control10=IDC_ABOUT,static,1342308608

[DLG:IDD_MODIBOX]
Type=1
Class=CModiBox
ControlCount=8
Control1=IDC_STATIC,button,1342177287
Control2=IDC_STATIC,static,1342308352
Control3=IDC_STATIC,static,1342308352
Control4=IDC_NAME,edit,1350631552
Control5=IDC_PHONE,edit,1350631552
Control6=IDC_OK,button,1342242816
Control7=IDC_CANCEL,button,1342242816
Control8=IDC_STATIC,button,1342177287

[DLG:IDD_SEARCH]
Type=1
Class=CSearchBox
ControlCount=6
Control1=IDC_STATIC,button,1342177287
Control2=IDC_STATIC,static,1342308352
Control3=IDC_NAME,edit,1350631552
Control4=IDC_OK,button,1342242816
Control5=IDC_CANCEL,button,1342242816
Control6=IDC_STATIC,button,1342177287

[DLG:IDD_ABOUT]
Type=1
Class=CAbout
ControlCount=5
Control1=IDC_STATIC,static,1342183438
Control2=IDC_STATIC,static,1342308352
Control3=IDC_STATIC,static,1342308352
Control4=IDOK,button,1342242816
Control5=IDC_STATIC,static,1342308352

[CLS:CAbout]
Type=0
HeaderFile=About.h
ImplementationFile=About.cpp
BaseClass=CDialog
Filter=D

