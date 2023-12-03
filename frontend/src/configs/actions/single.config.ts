import actionButton from "./type";
export const actionButtons: actionButton[] = [
  { link: "/powerMatrix", method: "POST", content: "Power Matrix" },
  { link: "/determinant", method: "POST", content: "Determinant" },
  { link: "/inverse", method: "POST", content: "Inverse" },
  { link: "/rang", method: "POST", content: "Rang" },
  { link: "/transpose", method: "POST", content: "Transpose" },
  {
    link: "/triangularShapeLower",
    method: "POST",
    content: "Triangular Shape Lower",
  },
  {
    link: "/triangularShapeUpper",
    method: "POST",
    content: "Triangular Shape Upper",
  },
];
