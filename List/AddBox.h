#if !defined(AFX_ADDBOX_H__4B9E1985_4470_4922_8624_C5FF56EBD6D5__INCLUDED_)
#define AFX_ADDBOX_H__4B9E1985_4470_4922_8624_C5FF56EBD6D5__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// AddBox.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CAddBox dialog

class CAddBox : public CDialog
{
// Construction
public:
	CString GetShowComb();
	CString GetSaveComb();
	void SetShowComb();
	void SetSaveComb();
	CAddBox(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(CAddBox)
	enum { IDD = IDD_ADD };
	CString	m_strName;
	CString	m_strPhone;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CAddBox)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CAddBox)
	virtual BOOL OnInitDialog();
	afx_msg void OnTimer(UINT nIDEvent);
	afx_msg void OnOk();
	afx_msg void OnCancel();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
private:
	CString m_showComb;
	CString m_saveComb;
	HICON m_icons[3];
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_ADDBOX_H__4B9E1985_4470_4922_8624_C5FF56EBD6D5__INCLUDED_)
