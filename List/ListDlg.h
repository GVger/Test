// ListDlg.h : header file
//

#if !defined(AFX_LISTDLG_H__52571ECF_18EE_4A44_AD61_6F4C5E576E13__INCLUDED_)
#define AFX_LISTDLG_H__52571ECF_18EE_4A44_AD61_6F4C5E576E13__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CListDlg dialog
#include "SearchBox.h"

class CListDlg : public CDialog
{
// Construction
public:
	CBrush m_BK;
	void SetSaveComb(CString Name,CString Phone);
	void SetShowComb(CString Name,CString Phone);
	CString FindPhone(CString str);
	CString FindName(CString str);
	CString GetPhone();
	CString GetName();
	void SetPhone(CString str);
	void SetName(CString str);
	void OpenVg();
	CString m_strPhone;
	CString GetSaveComb();
	CString GetshowComb();
	CListDlg(CWnd* pParent = NULL);	// standard constructor
	CListBox	m_Content;
// Dialog Data
	//{{AFX_DATA(CListDlg)
	enum { IDD = IDD_LIST_DIALOG };
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CListDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CListDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnTimer(UINT nIDEvent);
	afx_msg void OnOpen();
	afx_msg void OnSave();
	afx_msg void OnDblclkContent();
	afx_msg void OnAdd();
	afx_msg void OnChange();
	afx_msg void OnExit();
	afx_msg void OnSearch();
	afx_msg void OnAbout();
	afx_msg HBRUSH OnCtlColor(CDC* pDC, CWnd* pWnd, UINT nCtlColor);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
private:
	CString SaveString();
	CString m_strName;
	CString m_saveComb;
	CString m_showComb;
	CStringArray m_Open;
	HICON m_icons[3];
	bool isLager;						//标志是否有工作区
	CRect rectBefore;					//大的窗口
	CRect rectAfter;					//小的窗口
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LISTDLG_H__52571ECF_18EE_4A44_AD61_6F4C5E576E13__INCLUDED_)
